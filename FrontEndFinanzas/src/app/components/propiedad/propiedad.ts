// src/app/components/propiedad/propiedad.ts (CORREGIDO)

import { Component, OnInit, Inject, PLATFORM_ID } from '@angular/core';
import { isPlatformBrowser, CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { Propiedad as PropiedadModel } from '../../models/Propiedad'; // <-- CORRECCIÓN 1: Alias
import { PropiedadService } from '../../services/propiedad.service';

// Importa los módulos de Material para los botones y la tabla
import { MatIconModule } from '@angular/material/icon'; 
import { MatButtonModule } from '@angular/material/button'; 
import { MatTableModule } from '@angular/material/table';
import { MatSnackBar, MatSnackBarModule } from '@angular/material/snack-bar';

@Component({
  selector: 'app-propiedad',
  standalone: true,
  imports: [
    CommonModule, 
    RouterModule, 
    MatIconModule, 
    MatButtonModule, 
    MatTableModule,
    MatSnackBarModule
  ],
  templateUrl: './propiedad.html',
  styleUrls: ['./propiedad.css'] 
})
export class Propiedad implements OnInit { // <-- El componente se sigue llamando 'Propiedad'
  
  listaPropiedades: PropiedadModel[] = []; // <-- CORRECCIÓN 2: Usar el alias
  displayedColumns: string[] = ['id', 'tipo', 'direccion', 'precio', 'acciones'];

  constructor(
    private pS: PropiedadService,
    private snackBar: MatSnackBar,
    @Inject(PLATFORM_ID) private platformId: Object
  ) {}

  ngOnInit(): void {
    this.cargarPropiedades();
  }

  cargarPropiedades(): void {
    if (isPlatformBrowser(this.platformId)) {
      this.pS.list().subscribe(data => {
        this.listaPropiedades = data;
      });
    }
  }

  eliminar(id: number): void {
    if (confirm('¿Está seguro de que desea eliminar esta propiedad?')) {
      this.pS.delete(id).subscribe(() => {
        this.snackBar.open('Propiedad eliminada.', 'Cerrar', { duration: 3000 });
        this.cargarPropiedades(); // Recarga la lista
      });
    }
  }
}