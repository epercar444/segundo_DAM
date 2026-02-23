import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Author } from '../models/author';

@Component({
  selector: 'app-author',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './author.component.html'
})
export class AuthorComponent {
  authorArray: Author[] = [
    { id: 1, name: 'Gabriel García Márquez', nationality: 'Colombiana', birthYear: 1927 },
    { id: 2, name: 'George Orwell', nationality: 'Británica', birthYear: 1903 },
    { id: 3, name: 'Antoine de Saint-Exupéry', nationality: 'Francesa', birthYear: 1900 },
    { id: 4, name: 'Miguel de Cervantes', nationality: 'Española', birthYear: 1547 },
    { id: 5, name: 'J.R.R. Tolkien', nationality: 'Británica', birthYear: 1892 }
  ];

  selectedAuthor: Author = new Author();

  addOrEdit() {
    if (this.selectedAuthor.id === 0) {
      this.selectedAuthor.id = this.authorArray.length + 1;
      this.authorArray.push(this.selectedAuthor);
    }
    this.selectedAuthor = new Author();
  }

  openForEdit(author: Author) {
    this.selectedAuthor = author;
  }

  delete() {
    if (confirm('¿Estás seguro de querer eliminar este autor?')) {
      this.authorArray = this.authorArray.filter(x => x !== this.selectedAuthor);
      this.selectedAuthor = new Author();
    }
  }
}