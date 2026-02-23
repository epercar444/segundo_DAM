import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Reader } from '../models/reader';

@Component({
  selector: 'app-reader',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './reader.component.html'
})
export class ReaderComponent {
  readerArray: Reader[] = [
    { id: 1, name: 'Ana García', email: 'ana@email.com', age: 28 },
    { id: 2, name: 'Luis Martínez', email: 'luis@email.com', age: 35 },
    { id: 3, name: 'María López', email: 'maria@email.com', age: 22 }
  ];

  selectedReader: Reader = new Reader();

  addOrEdit() {
    if (this.selectedReader.id === 0) {
      this.selectedReader.id = this.readerArray.length + 1;
      this.readerArray.push(this.selectedReader);
    }
    this.selectedReader = new Reader();
  }

  openForEdit(reader: Reader) {
    this.selectedReader = reader;
  }

  delete() {
    if (confirm('¿Estás seguro de querer eliminar este lector?')) {
      this.readerArray = this.readerArray.filter(x => x !== this.selectedReader);
      this.selectedReader = new Reader();
    }
  }
}