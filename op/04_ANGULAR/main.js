"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
// main.ts
var saludos = function (persona) {
    return "Hola, " + persona;
};
var usuario = "Marcos";
var sentencia = "Hola, mi nombre es ".concat(usuario);
console.log(usuario);
document.body.innerHTML = saludos(usuario);
