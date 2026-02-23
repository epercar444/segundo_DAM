import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Book } from '../models/book';

@Component({
  selector: 'app-book',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './book.component.html'
})
export class BookComponent {
  bookArray: Book[] = [
    { id: 1, title: 'Cien años de soledad', author: 'Gabriel García Márquez', pages: 432 },
    { id: 2, title: '1984', author: 'George Orwell', pages: 328 },
    { id: 3, title: 'El principito', author: 'Antoine de Saint-Exupéry', pages: 96 },
    { id: 4, title: 'Don Quijote de la Mancha', author: 'Miguel de Cervantes', pages: 1032 },
    { id: 5, title: 'El Hobbit', author: 'J.R.R. Tolkien', pages: 310 },
    { id: 6, title: 'Crónica de una muerte anunciada', author: 'G. García Márquez', pages: 150 }
  ];

  selectedBook: Book = new Book();

  addOrEdit() {
    if (this.selectedBook.id === 0) {
      this.selectedBook.id = this.bookArray.length + 1;
      this.bookArray.push(this.selectedBook);
    }
    this.selectedBook = new Book();
  }

  openForEdit(book: Book) {
    this.selectedBook = book;
  }

  delete() {
    if (confirm('¿Estás seguro de querer eliminar este libro?')) {
      this.bookArray = this.bookArray.filter(x => x !== this.selectedBook);
      this.selectedBook = new Book();
    }
  }
}