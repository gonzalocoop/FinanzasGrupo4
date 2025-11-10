import { Component, OnInit, Inject, PLATFORM_ID } from '@angular/core';
import { isPlatformBrowser, CommonModule } from '@angular/common';
import { RouterModule, Router } from '@angular/router';
import { CreditoMiVivienda } from '../../models/CreditoMiVivienda';
import { CreditomiviviendaService } from '../../services/creditomivivienda.service';
import { LoginService } from '../../services/login.service'; 

import { MatIconModule } from '@angular/material/icon'; 
import { MatButtonModule } from '@angular/material/button'; 
import { MatTableModule } from '@angular/material/table';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';

@Component({
  selector: 'app-creditomivivienda',
  standalone: true,
  imports: [
    CommonModule, 
    RouterModule, 
    MatIconModule, 
    MatButtonModule, 
    MatTableModule,
    MatSnackBarModule
  ],
  templateUrl: './creditomivivienda.html',
  styleUrls: ['./creditomivivienda.css'] 
})
export class Creditomivivienda implements OnInit {
  
  listaCreditos: CreditoMiVivienda[] = [];
  displayedColumns: string[] = ['id', 'propiedad', 'moneda', 'cuota_inicial', 'tasa_interes', 'acciones'];
  isAdmin: boolean = false;

  constructor(
    private cmvS: CreditomiviviendaService,
    private snackBar: MatSnackBar,
    private loginService: LoginService,
    private router: Router,
    @Inject(PLATFORM_ID) private platformId: Object
  ) {}

  ngOnInit(): void {
    this.isAdmin = (this.loginService.showRole() === 'ADMINISTRADOR');
    if (!this.isAdmin) {
      this.displayedColumns = ['id', 'propiedad', 'moneda', 'cuota_inicial', 'tasa_interes'];
    }
    this.cargarCreditos();
  }

  cargarCreditos(): void {
    if (isPlatformBrowser(this.platformId)) {
      this.cmvS.list().subscribe(data => {
        if (this.isAdmin) {
          this.listaCreditos = data; // Admin ve todo
        } else {
          // Usuario ve solo los suyos
          const username = localStorage.getItem('username');
          this.listaCreditos = data.filter(c => c.usuario?.username === username);
        }
      });
    }
  }

  eliminar(id: number): void {
    if (confirm('¿Está seguro de que desea eliminar este crédito?')) {
      this.cmvS.delete(id).subscribe(() => {
        this.snackBar.open('Crédito eliminado.', 'Cerrar', { duration: 3000 });
        this.cargarCreditos(); // Recarga la lista
      });
    }
  }

  volverAlMenu() {
    const returnUrl = this.isAdmin ? '/admin/propiedades' : '/homes'; 
    this.router.navigate([returnUrl]);
  }
}