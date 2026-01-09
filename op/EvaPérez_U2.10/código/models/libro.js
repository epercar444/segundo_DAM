const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const libroSchema = new Schema({
    isbn: String,
    titulo: String,
    autor: String,
    numeroPaginas : Number
})

//Creamos el modelo
const Libro = mongoose.model('libro', libroSchema, "libro");

module.exports = Libro;