import { Component, signal } from '@angular/core';

@Component({
  selector: 'app-inicio',
  standalone: true,
  template: `
    <div class="hero-section">
      <h1>Bienvenido a {{ nombreConcesionario() }}</h1>
      <p>Líderes en el sector de venta automóvilísticas desde 2026.</p>
    </div>
  `,//metemos la información en un div para darle algún diseño
  styles: [`.hero-section { padding: 50px; text-align: center; background: #eee; }`]
}) //estilos integrados para ahorrar clases
export class InicioComponent {
  nombreConcesionario = signal('Automóviles Torre de los Guzmanes');
}
//Usamos la interpolación para que el nombre del concesionario no sea estático