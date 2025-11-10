// src/app/app.routes.ts (Actualizado para tu nueva estructura)
import { Routes } from '@angular/router';

// Componentes del flujo principal
import { HomeComponent } from './components/home/home.component';
import { LandingpageComponent } from './components/landingpage/landingpage.component';
import { IniciosesionComponent } from './components/iniciosesion/iniciosesion.component';
import { RegistrarusuarioComponent } from './components/registrarusuario/registrarusuario.component';

// Componentes de Propiedad
import { Propiedad } from './components/propiedad/propiedad'; // LISTA de Propiedades (Admin)
import { CrearpropiedadComponent } from './components/propiedad/crearpropiedad/crearpropiedad.component'; // FORM de Propiedad

// Componentes de Crédito
import { Creditomivivienda } from './components/creditomivivienda/creditomivivienda'; // LISTA de Créditos (User/Admin)
import { CrearcreditomiviviendaComponent } from './components/creditomivivienda/crearcreditomivivienda/crearcreditomivivienda.component'; // FORM de Crédito

import { seguridadGuard } from './guard/seguridad.guard'; // Tu guard existente

export const routes: Routes = [
    // --- Rutas Públicas ---
    { path: '', redirectTo: '/landing', pathMatch: 'full' },
    { path: 'landing', component: LandingpageComponent },
    { path: 'iniciosesion', component: IniciosesionComponent },
    { path: 'registrarusuario', component: RegistrarusuarioComponent },

    // --- Rutas de USUARIO (Protegidas) ---
    {
        path: 'homes', // Menú de Usuario
        component: HomeComponent,
        canActivate: [seguridadGuard] 
    },
    {
        path:'usuario/nueva-propiedad', // Flujo de Usuario: Crear Propiedad (Paso 1)
        component: CrearpropiedadComponent,
        canActivate: [seguridadGuard],
        data: { isUserFlow: true } 
    },
    {
        path:'creditoMiVivienda', // Flujo de Usuario: Listar Créditos
        component: Creditomivivienda, // <-- Usa la LISTA
        canActivate: [seguridadGuard] 
    },
    {
        path: 'creditoMiVivienda/nuevo/:idPropiedad', // Flujo de Usuario: Crear Crédito (Paso 2)
        component: CrearcreditomiviviendaComponent, // <-- Usa el FORM
        canActivate: [seguridadGuard],
        data: { isUserFlow: true }
    },

    // --- Rutas de ADMIN (Protegidas) ---
    {
        path: 'admin/propiedades', // Admin: VER lista de propiedades
        component: Propiedad,
        canActivate: [seguridadGuard] // (Aquí podrías usar tu adminGuard si lo creas)
    },
    {
        path: 'admin/propiedades/nueva', // Admin: REGISTRAR propiedad
        component: CrearpropiedadComponent,
        canActivate: [seguridadGuard]
    },
    {
        path: 'admin/propiedades/editar/:id', // Admin: ACTUALIZAR propiedad
        component: CrearpropiedadComponent,
        canActivate: [seguridadGuard]
    },
    {
        path: 'admin/creditos', // Admin: VER lista de créditos
        component: Creditomivivienda, // <-- Usa la LISTA
        canActivate: [seguridadGuard]
    },
    {
        path: 'admin/creditos/editar/:id', // Admin: ACTUALIZAR crédito
        component: CrearcreditomiviviendaComponent, // <-- Usa el FORM
        canActivate: [seguridadGuard]
    },
    
    // ... (resto de tus rutas)
];