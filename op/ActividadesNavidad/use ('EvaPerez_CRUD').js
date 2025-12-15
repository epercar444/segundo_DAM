use ('EvaPerez_CRUD')

db.createCollection('libros')

db.libros.insertMany([
    {
        "isbn": "978-84-415-3971-5",
        "titulo": "Patrones de Diseño: Elementos de Software Reutilizable",
        "autor": "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides",
        "numeroPaginas": 435
    },
    {
        "isbn": "978-84-154-1383-7",
        "titulo": "Clean Code: Manual de Programación Ágil",
        "autor": "Robert C. Martin",
        "numeroPaginas": 464
    },
    {
        "isbn": "978-01-346-8599-1",
        "titulo": "Introduction to Algorithms",
        "autor": "Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest, Clifford Stein",
        "numeroPaginas": 1312
    }
])
