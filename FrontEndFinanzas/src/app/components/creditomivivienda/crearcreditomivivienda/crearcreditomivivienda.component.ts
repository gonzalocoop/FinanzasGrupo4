import { Component, OnInit, Inject, PLATFORM_ID } from '@angular/core';
import { isPlatformBrowser, CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router, ActivatedRoute, RouterModule } from '@angular/router';
import { CreditoMiVivienda } from '../../../models/CreditoMiVivienda';
import { CreditomiviviendaService } from '../../../services/creditomivivienda.service';
import { MonedaService } from '../../../services/moneda.service';
import { UsuariosService } from '../../../services/usuarios.service';
import { Moneda } from '../../../models/Moneda';
import { Usuarios } from '../../../models/Usuarios';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';

@Component({
  selector: 'app-crearcreditomivivienda',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, RouterModule, MatSnackBarModule],
  templateUrl: './crearcreditomivivienda.component.html',
  styleUrls: ['./crearcreditomivivienda.component.css']
})
export class CrearcreditomiviviendaComponent implements OnInit {
  form: FormGroup= new FormGroup({});
  credito: CreditoMiVivienda = new CreditoMiVivienda();
  
  isUserFlow: boolean = false;
  isEditMode: boolean = false;
  idPropiedadRecibida: number = 0;
  idCreditoParaEditar: number = 0;

  listaMonedas: Moneda[] = [];
  currentUser: Usuarios | undefined;

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private route: ActivatedRoute,
    private cmvS: CreditomiviviendaService,
    private mS: MonedaService,
    private uS: UsuariosService,
    private snackBar: MatSnackBar,
    @Inject(PLATFORM_ID) private platformId: Object
  ) {}

  ngOnInit(): void {
    this.form = this.fb.group({
      fecha_inicio: [new Date().toISOString().split('T')[0], Validators.required],
      moneda: [null, Validators.required],
      cuota_inicial: [null, [Validators.required, Validators.min(0)]],
      tipo_tasa: ['NOMINAL', Validators.required],
      tasa_interes: [null, [Validators.required, Validators.min(0), Validators.max(1)]],
      peridiocidad_tasa: ['MENSUAL', Validators.required],
      tipo_capitalizacion: ['DIARIA', Validators.required],
      tipo_gracia: ['NINGUNO', Validators.required],
      duracion_gracia_meses: [0, [Validators.required, Validators.min(0)]],
    });

    this.route.paramMap.subscribe(params => {
      if (params.has('id')) { // Flujo de Edición (Admin)
        this.isEditMode = true;
        this.idCreditoParaEditar = +params.get('id')!;
        this.cmvS.listId(this.idCreditoParaEditar).subscribe(data => {
          this.form.patchValue(data); 
          this.form.controls['moneda'].setValue(data.moneda.id_moneda);
        });

      } else if (params.has('idPropiedad')) { // Flujo de Creación (Usuario)
        this.isUserFlow = true;
        this.idPropiedadRecibida = +params.get('idPropiedad')!;
      }
    });

    this.loadMonedas();
    this.loadCurrentUser();
  }

  loadMonedas() {
    if (isPlatformBrowser(this.platformId)) {
      this.mS.list().subscribe(data => { this.listaMonedas = data; });
    }
  }

  loadCurrentUser() {
     if (isPlatformBrowser(this.platformId)) {
      const username = localStorage.getItem('username'); 
      if (username) {
        this.uS.findByUsername(username).subscribe(user => { this.currentUser = user; });
      } else {
        console.error("No se encontró el username en localStorage.");
      }
     }
  }

  aceptar() {
    if (this.form.invalid || !this.currentUser) {
       this.snackBar.open('Formulario inválido o no se pudo cargar el usuario.', 'Cerrar', { duration: 3000 });
       this.form.markAllAsTouched();
       return;
    }

    this.credito.fecha_inicio = this.form.value.fecha_inicio;
    this.credito.tipo_tasa = this.form.value.tipo_tasa;
    this.credito.tasa_interes = this.form.value.tasa_interes;
    this.credito.peridiocidad_tasa = this.form.value.peridiocidad_tasa;
    this.credito.tipo_capitalizacion = this.form.value.tipo_capitalizacion;
    this.credito.cuota_inicial = this.form.value.cuota_inicial;
    this.credito.tipo_gracia = this.form.value.tipo_gracia;
    this.credito.duracion_gracia_meses = this.form.value.duracion_gracia_meses;
    
    this.credito.moneda.id_moneda = this.form.value.moneda;
    this.credito.usuario = this.currentUser; 

    if (this.isEditMode) {
      this.credito.id_credito = this.idCreditoParaEditar;
      this.cmvS.update(this.credito).subscribe(() => {
        this.snackBar.open('Crédito actualizado.', 'Cerrar', { duration: 3000 });
        this.router.navigate(['/admin/creditos']);
      });

    } else {
      if (this.isUserFlow) {
        this.credito.propiedad.id_propiedad = this.idPropiedadRecibida;
      } else {
        alert('Flujo de admin crear crédito necesita un selector de propiedad (no implementado).');
        return; 
      }
      
      this.cmvS.insert(this.credito).subscribe(() => {
        this.snackBar.open('¡Crédito registrado exitosamente!', 'Cerrar', { duration: 3000 });
        const returnUrl = this.isUserFlow ? '/homes' : '/admin/creditos';
        this.router.navigate([returnUrl]);
      });
    }
  }

  getTitulo(): string {
    if (this.isEditMode) { return 'Editar Crédito Mivivienda'; }
    else if (this.isUserFlow) { return `Paso 2: Registrar Crédito (Propiedad ID: ${this.idPropiedadRecibida})`; }
    else { return 'Registrar Nuevo Crédito (Admin)'; }
  }

  cancelar() {
    const returnUrl = this.isUserFlow ? '/homes' : '/admin/creditos';
    this.router.navigate([returnUrl]);
  }
}