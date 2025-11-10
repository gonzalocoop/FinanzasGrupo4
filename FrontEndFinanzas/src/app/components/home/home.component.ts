// src/app/components/home/home.ts

import { Component } from '@angular/core';
import { RouterModule } from '@angular/router'; 
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { CommonModule } from '@angular/common';
import { LoginService } from '../../services/login.service';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    CommonModule,
    RouterModule, 
    MatToolbarModule,
    MatButtonModule,
    MatIconModule
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css' 
})
export class HomeComponent {
   selectedUser: string = localStorage.getItem("username") ?? "";
  role: string = '';
  constructor(private lS: LoginService) {}
  verificar() {
    this.role = this.lS.showRole();
    return this.lS.verificar();
  }
}