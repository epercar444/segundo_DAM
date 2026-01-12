// main.ts
let saludos = (persona: string) => {
return "Hola, " + persona;
}
let usuario: string = "Marcos";
let sentencia = `Hola, mi nombre es ${usuario}`;
console.log(usuario);
document.body.innerHTML = saludos(usuario);
export{};