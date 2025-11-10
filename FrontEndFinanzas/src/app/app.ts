import { Component, signal } from '@angular/core';
// 1. Importa 'Router' (además de RouterModule y RouterOutlet)
import { RouterModule, RouterOutlet, Router } from '@angular/router'; 
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { MatButtonModule } from '@angular/material/button';
import { CommonModule } from '@angular/common';
import { LoginService } from './services/login.service';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,CommonModule,MatToolbarModule,MatIconModule, MatMenuModule, MatButtonModule, RouterModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
   title = 'FrontEndFinanzas';

  role: string = '';
  
  // 2. Inyecta el Router en el constructor
  constructor(
    private lS: LoginService,
    private router: Router // <-- AÑADE ESTO
  ) {}

  cerrar() {
    sessionStorage.clear();
    localStorage.clear();
    
    // 3. Añade la navegación al login
    this.router.navigate(['/iniciosesion']); // <-- AÑADE ESTO
  }

  verificar() {
    this.role = this.lS.showRole();
    return this.lS.verificar();
  }
  isAdmin() {
    return this.role === 'ADMINISTRADOR';
  }

  isStudent() {
    return this.role === 'USUARIO';
  }
}