import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { MatToolbarModule } from '@angular/material/toolbar';
import { ActivatedRoute, NavigationEnd, Router, RouterModule, RouterOutlet } from '@angular/router';
import { LoginService } from '../../services/login.service';
import { ResumenFinancieroUsuarioDTO } from '../../models/ResumenFinancieroUsuarioDTO';
@Component({
  selector: 'app-reportes',
  standalone: true,
  imports: [CommonModule,RouterOutlet,RouterModule,MatToolbarModule,MatIconModule, MatMenuModule, MatButtonModule],
  templateUrl: './reportes.html',
  styleUrl: './reportes.css',
})
export class Reportes implements OnInit{
  idUsuarioActual: number = 0;
  showWelcomeMessage = true;
  selectedUser: string = localStorage.getItem("username") ?? "";
  role: string = '';
  constructor(private route: ActivatedRoute,private router: Router,private loginService: LoginService) {}

  


  ngOnInit(): void {
    this.role = this.loginService.showRole();
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        // Oculta el mensaje si la ruta actual es un reporte específico
        this.showWelcomeMessage = this.router.url === '/reportes';
      }
    });

    const sesion = sessionStorage.getItem('username') || localStorage.getItem('username');
  if (sesion) {
    const userObj = JSON.parse(sesion);
    // Asegúrate de usar la propiedad correcta (id_usuario, id, etc.)
    this.idUsuarioActual = Number(userObj.id_usuario || userObj.id);
  }

  // 2. Si falló la sesión, intentamos leer de la URL (Fallback)
  if (!this.idUsuarioActual) {
      const idCapturado = this.route.snapshot.paramMap.get('idUsuario');
      if (idCapturado) {
        this.idUsuarioActual = Number(idCapturado);
      }
  }
  console.log("ID para el botón:", this.idUsuarioActual);
  }
  verificar() {
    this.role = this.loginService.showRole();
    return this.loginService.verificar();
  }
  isAdmin() {
  return this.role === 'ADMINISTRADOR';
  }

  isStudent() {
  return this.role === 'USUARIO';
  }
}
