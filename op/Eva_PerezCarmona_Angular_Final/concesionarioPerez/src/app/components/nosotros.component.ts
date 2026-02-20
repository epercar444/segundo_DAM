import { Component } from '@angular/core';

@Component({
  selector: 'app-nosotros',
  standalone: true,
  //definición de la vista tal y cómo la queremos
  template: ` 
    <section class="nosotros">
      <h2>Quiénes Somos</h2>
      <p>Somos un concesionario líder en La Algaba, especializados en vehículos de alta gama y utilitarios.</p>
      <ul>
        <li>Más de 20 años de experiencia.</li>
        <li>Taller propio certificado.</li>
        <li>Financiación a medida.</li>
      </ul>
        <h2>Dueños</h2>
        <p>Nuestros dueños son algabeeños que garantizan la calidad a sus vecinos, comprando, mejorando y vendiendo sólo lo que el pueblo necesita</p>
              <ul>
        <li>Eva Pérez Carmona</li>
        <li>Javier Prada Oliva</li>
      </ul>
    </section>
  `
})
export class NosotrosComponent {}