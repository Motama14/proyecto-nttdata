import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, RouterLink, RouterLinkActive],
  template: `
    <header class="topbar">
      <div>
        <h1>Gestión del zoológico</h1>
        <p>Proyecto con Angular y Spring Boot</p>
      </div>
      <nav>
        <a routerLink="/" routerLinkActive="active" [routerLinkActiveOptions]="{ exact: true }">Inicio</a>
        <a routerLink="/cuidadores" routerLinkActive="active">Cuidadores</a>
        <a routerLink="/cuidadores/nuevo" routerLinkActive="active">Nuevo cuidador</a>
        <a routerLink="/animales/nuevo" routerLinkActive="active">Nuevo animal</a>
      </nav>
    </header>

    <main class="container">
      <router-outlet></router-outlet>
    </main>
  `
})
export class AppComponent {
}
