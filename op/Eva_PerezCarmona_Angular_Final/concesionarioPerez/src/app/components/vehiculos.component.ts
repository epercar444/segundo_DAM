import { Component } from '@angular/core';
import { CommonModule } from '@angular/common'; 
import { Coche } from '../models/coche'; 

@Component({
  selector: 'app-vehiculos',
  standalone: true,
  imports: [CommonModule],
  template: `
    <h2>Catálogo del Concesionario</h2>
    <div class="lista-coches">
      <div *ngFor="let c of coches" class="coche-card">
        <h3>{{ c.marca }} {{ c.modelo }}</h3>
        <p>Precio: {{ c.precio | currency:'EUR' }}</p> 
        
        <p *ngIf="c.disponible; else agotado" style="color: green;">Disponible</p>
        <ng-template #agotado>
          <p style="color: red;">Reservado</p>
        </ng-template>
      </div>
    </div>
  `
})
export class VehiculosComponent {
  coches: Coche[] = [
    new Coche(1, 'Toyota', 'Corolla', 24000, true),
    new Coche(2, 'BMW', 'Serie 3', 42000, false),
    new Coche(3, 'Seat', 'Ibiza', 18000, true),
    new Coche(4, 'Ford', 'Mustang', 70000, true),
  ]; //definimos e inicializamos datos de tipo coche
}