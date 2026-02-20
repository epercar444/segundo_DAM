import { Component, signal } from '@angular/core';

@Component({
  selector: 'app-contacto',
  standalone: true,
  template: `
      <h2>Contacto - {{ nombreConcesionario() }}</h2>
      <p>Puedes visitarnos en la calle Pilar García 3, La Algaba</p>
      <p>Teléfono : 66666666</p>
      <p>Correo electrónico : concesionarioPerez@gmail.com </p>
      
      <div>
        <p>Gracias por confiar en <strong>{{ nombreConcesionario() }}</strong></p>
      </div>
  `,
  styles: [`
    .formulario-contacto { 
      padding: 30px; 
      border: 1px solid #ccc; 
      border-radius: 10px;
      line-height: 1.6;
    }
    .footer-info {
      margin-top: 20px;
      color: #555;
      font-style: italic;
    }
  `]
})
export class ContactoComponent {
  //definimos nombre concesionario como en inicio
  nombreConcesionario = signal('Automóviles Torre de los Guzmanes');
}