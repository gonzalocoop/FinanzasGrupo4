import { Component, OnInit, Inject, PLATFORM_ID } from '@angular/core'; // <-- Añade Inject y PLATFORM_ID
import { isPlatformBrowser, CommonModule } from '@angular/common'; // <-- Añade isPlatformBrowser
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router, RouterModule, ActivatedRoute } from '@angular/router';
import { Propiedad } from '../../../models/Propiedad'; 
import { PropiedadService } from '../../../services/propiedad.service';
import { MonedaService } from '../../../services/moneda.service'; // <-- AÑADIDO
import { Moneda } from '../../../models/Moneda'; // <-- AÑADIDO

@Component({
  selector: 'app-crearpropiedad',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, RouterModule],
  templateUrl: './crearpropiedad.component.html',
  styleUrls: ['./crearpropiedad.component.css']
})
export class CrearpropiedadComponent implements OnInit {
  form: FormGroup= new FormGroup({});
  propiedad: Propiedad = new Propiedad();
  
  isUserFlow: boolean = false; 
  isEditMode: boolean = false; 
  idToEdit: number = 0;
  
  listaMonedas: Moneda[] = []; // <-- AÑADIDO

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private pS: PropiedadService,
    private route: ActivatedRoute,
    private mS: MonedaService, // <-- AÑADIDO
    @Inject(PLATFORM_ID) private platformId: Object // <-- AÑADIDO
  ) {}

  ngOnInit(): void {
    // 1. Revisar si es Flujo de Usuario
    if (this.route.snapshot.data['isUserFlow']) {
      this.isUserFlow = true;
    }

    // 2. Revisar si estamos en modo Edición (Admin)
    this.route.paramMap.subscribe(params => {
      if (params.has('id')) {
        this.isEditMode = true;
        this.idToEdit = +params.get('id')!;
        this.pS.listId(this.idToEdit).subscribe(data => {
          this.form.patchValue(data); 
          // (Faltaría rellenar los campos nuevos si vienes de 'editar')
        });
      }
    });
    
    // 3. Crear el formulario (ACTUALIZADO con los campos del Paso 4)
    this.form = this.fb.group({
      tipo_propiedad: ['', Validators.required],
      direccion: ['', Validators.required],
      precio_propiedad: [null, [Validators.required, Validators.min(1)]],
      // --- NUEVOS CAMPOS ---
      tipo_moneda: [null, Validators.required], 
      costos_notariales: [null, [Validators.required, Validators.min(0)]],
      registros_publicos: [null, [Validators.required, Validators.min(0)]],
      costos_transaccion: [null, [Validators.required, Validators.min(0)]]
    });

    // 4. Cargar monedas para el <select>
    this.loadMonedas();
  }

  loadMonedas() {
    // Arreglado: Llama al servicio de moneda (mS) solo en el navegador
    if (isPlatformBrowser(this.platformId)) {
      this.mS.list().subscribe(data => {
        this.listaMonedas = data;
      });
    }
  }

  aceptar() {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }

    // Objeto base de la propiedad
    this.propiedad.tipo_propiedad = this.form.value.tipo_propiedad;
    this.propiedad.direccion = this.form.value.direccion;
    this.propiedad.precio_propiedad = this.form.value.precio_propiedad;

    // --- Objeto completo con los NUEVOS CAMPOS ---
    // (Este es el 'datosCompletos' que te mencioné)
    const datosCompletos = {
      ...this.propiedad,
      tipo_moneda: this.form.value.tipo_moneda,
      costos_notariales: this.form.value.costos_notariales,
      registros_publicos: this.form.value.registros_publicos,
      costos_transaccion: this.form.value.costos_transaccion
    };

    if (this.isEditMode) {
      this.propiedad.id_propiedad = this.idToEdit;
      // El update también debería enviar 'datosCompletos'
      this.pS.update(datosCompletos as Propiedad).subscribe(() => { 
        alert('Propiedad actualizada correctamente.');
        this.router.navigate(['/admin/propiedades']);
      });
      
    } else {
      // Enviamos el objeto con TODOS los datos
      this.pS.insert(datosCompletos as Propiedad).subscribe({ 
        next: (nuevaPropiedad: Propiedad) => {
          if (this.isUserFlow) {
            alert('Propiedad registrada. Ahora, registra los datos del crédito.');
            this.router.navigate(['/creditoMiVivienda/nuevo/', nuevaPropiedad.id_propiedad]);
          } else {
            alert('Propiedad registrada por el Administrador.');
            this.router.navigate(['/admin/propiedades']);
          }
        },
        error: (err) => {
           console.error('Error al registrar la propiedad:', err);
           alert('Error al registrar la propiedad. Revisa la consola o avisa al desarrollador de backend.');
        }
      });
    }
  }

  // --- Funciones para el HTML ---
  getTitulo(): string {
    if (this.isEditMode) { return 'Editar Propiedad'; } 
    else if (this.isUserFlow) { return 'Paso 1: Registrar Propiedad'; } 
    else { return 'Registrar Nueva Propiedad (Admin)'; }
  }

  getBotonPrincipal(): string {
    if (this.isEditMode) { return 'Actualizar Propiedad'; } 
    else if (this.isUserFlow) { return 'Siguiente (Crear Crédito)'; } 
    else { return 'Guardar Propiedad'; }
  }

  cancelar() {
    if (this.isUserFlow) { this.router.navigate(['/homes']); } 
    else { this.router.navigate(['/admin/propiedades']); }
  }
}