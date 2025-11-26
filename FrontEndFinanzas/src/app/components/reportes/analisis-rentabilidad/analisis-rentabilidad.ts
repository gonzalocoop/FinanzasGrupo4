import { Component, OnInit } from '@angular/core';
import { QueryAnalisisRentabilidad } from '../../../models/QueryAnalisisRentabilidad';
import { UsuariosService } from '../../../services/usuarios.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { MatButtonModule } from '@angular/material/button';
import { MatTableModule } from '@angular/material/table';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatInputModule } from '@angular/material/input';
import { MatNativeDateModule } from '@angular/material/core';

@Component({
  selector: 'app-analisis-rentabilidad',
  standalone: true,
  imports: [MatNativeDateModule,MatTableModule,MatFormFieldModule,FormsModule,MatInputModule, MatSelectModule,MatDatepickerModule,MatButtonModule,ReactiveFormsModule,CommonModule],
  templateUrl: './analisis-rentabilidad.html',
  styleUrl: './analisis-rentabilidad.css',
})
export class AnalisisRentabilidad implements OnInit{
  id_usuario: number = 0;
  analisis: QueryAnalisisRentabilidad[] = []
  haRealizadoBusqueda: boolean = false;
  constructor(private usuarioService:UsuariosService){}

  ngOnInit(): void {
    
  }
  cargarAnalisis(): void {
    // Verifica que las fechas sean válidas antes de enviarlas
    this.haRealizadoBusqueda = true;
    if (this.id_usuario) {
      // Llama al servicio con las fechas como objetos Date
      this.usuarioService.analisisderentabilidadporcreditodeusuario(this.id_usuario)
        .subscribe(
          (data: QueryAnalisisRentabilidad[]) => {
            this.analisis = data;
          },
          (error) => {
            console.error('Error al obtener la recaudación:', error);
          }
        );
    }
  }
  limpiarBusqueda() {
  this.haRealizadoBusqueda = false;
  this.analisis = []; // Opcional: limpiar tabla anterior
}
}
