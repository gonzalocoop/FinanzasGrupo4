// src/app/app.config.ts (CORREGIDO)

import { ApplicationConfig, importProvidersFrom, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideClientHydration } from '@angular/platform-browser';
import { provideHttpClient, withFetch, withInterceptorsFromDi } from '@angular/common/http';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { provideCharts, withDefaultRegisterables } from 'ng2-charts';
import { JwtModule } from '@auth0/angular-jwt';


// 1. FUNCIÓN tokenGetter CORREGIDA PARA SSR
export function tokenGetter() {
  // Solo intenta acceder a sessionStorage si estás en el navegador
  if (typeof window !== 'undefined' && window.sessionStorage) {
    return sessionStorage.getItem('token');
  }
  return null;
}

export const appConfig: ApplicationConfig = {
  providers: [
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes),
    provideClientHydration(),
    provideHttpClient(withInterceptorsFromDi()), 
    provideAnimationsAsync(), 
    provideCharts(withDefaultRegisterables()),
    importProvidersFrom(
      JwtModule.forRoot({
        config: {
          tokenGetter: tokenGetter,
          
          
          allowedDomains: ['localhost:8081'], 
          
       
          disallowedRoutes: [
          
            'http://localhost:8081/login', 
            'http://localhost:8081/registrarusuario',
            'http://localhost:8081/registrarusuario/listarusuarios',
            'http://localhost:8081/registrarusuario/listarroles',

            
            'http://localhost:8081/api/v1/authentication/**',
            'http://localhost:8081/v3/api-docs/**',
            'http://localhost:8081/swagger-ui.html',
            'http://localhost:8081/swagger-ui/**',
            'http://localhost:8081/swagger-resources/**',
            'http://localhost:8081/webjars/**'
          ],
        },
      })
    )
  ],
};