//funcion para ahorrarnos el querySelector en todas los métodos
function $(selector) {
  return document.querySelector(selector);
}

//función para mostrar y ocultar los elmentos modificando el style.display
function muestra(elemento) {
  elemento.style.display = "block";
}

function oculta(elemento) {
  elemento.style.display = "none";
    const inputs = elemento.querySelectorAll("input, select, textarea");
  inputs.forEach(input => {
    if (input.tagName === "SELECT") {
      input.value = ""; // vuelve a la opción por defecto
    } else if (input.type === "text" || input.type === "number" || input.type === "date" || input.type === "email") {
      input.value = ""; // limpia valor
  }});
}
 //Funciones para ocultar todos los atributos siguientes en el caso de no validar dicho atributo. Se llamarán en las diferentes funciones de validación.
function ocultaFieldsFromSurname() {
  oculta($("#field-surname"));
  ocultaFieldsFromEmail();
}
function ocultaFieldsFromEmail() {
  oculta($("#field-email"));
  ocultaFieldsFromPhone();
}
function ocultaFieldsFromPhone() {
  oculta($("#field-phone"));
  ocultaFieldsFromDNI();
}
function ocultaFieldsFromDNI() {
  oculta($("#field-dni"));
  ocultaFieldsFromCategory();
}
function ocultaFieldsFromCategory() {
  oculta($("#field-category"));
  ocultaFieldsFromTeam();
}
function ocultaFieldsFromTeam() {
  oculta($("#field-team"));
  ocultaFieldsFromMatch();
}
function ocultaFieldsFromMatch() {
  oculta($("#field-match"));
  ocultaFieldsFromDate();
}
function ocultaFieldsFromDate() {
  oculta($("#field-date"));
  ocultaFieldsFromShirt();
}
function ocultaFieldsFromShirt() {
  oculta($("#field-shirt"));
  ocultaFieldsFromButton(); 
}
function ocultaFieldsFromButton() { 
  oculta($("#field-button"));
}

//Validaciones de los atributos
function validaName() {
  const name = $("#name");
  name.setCustomValidity(""); //borramos errores anteriores
  if (name.value.length > 2) {
    muestra($("#field-surname"));
  } else {
    name.setCustomValidity("Introduce un nombre correcto"); //error que queremos que salga por pantalla
    name.reportValidity(); //estamos mandándolo para salida por pantalla
    ocultaFieldsFromSurname(); //Ocultar los atributos siguientes, todos. Todas las funciones lo contienen.
  }
}

function validaSurname() {
  const surname = $("#surname");
  surname.setCustomValidity("");
  const parts = surname.value.trim().split(" ");
  if ((parts.length === 1 && parts[0].length > 2) || // un solo apellido válido
    (parts.length === 2 && parts[0].length > 2 && parts[1].length > 2) // dos apellidos válidos
  ) {
    muestra($("#field-email"));
  } else {
    surname.setCustomValidity("Introduce unos apellidos correctos");
    surname.reportValidity();
    ocultaFieldsFromEmail();
  }
}

function validaEmail() {
  const email = $("#email");
  email.setCustomValidity("");
  if (email.checkValidity()) { //Uso checkValidity() unicamente en los atributos que HTML5 puede validar por el type del atributo.
    muestra($("#field-phone"));
  } else {
    email.setCustomValidity("Introduce un email válido");
    email.reportValidity();
    ocultaFieldsFromPhone();
  }
}

function validaPhone() {
  const phone = $("#phone");
  phone.setCustomValidity("");
  if (phone.checkValidity() && phone.value.length === 9) {
    muestra($("#field-dni"));
  } else {
    phone.setCustomValidity("Introduce un teléfono válido");
    phone.reportValidity();
    ocultaFieldsFromDNI();
  }
}

function validaDNI() {
  const dni = $("#dni");
  const regex = /^[0-9]{8}[A-Z]$/; //Expresión regular para validar el DNI
  dni.setCustomValidity("");
  if (regex.test(dni.value.toUpperCase())) { //deja introducir palabras en minúscula ya que aquí la estamos pasando a mayúsculas
    muestra($("#field-category"));
  } else {
    dni.setCustomValidity("Introduce un DNI correcto");
    dni.reportValidity();
    ocultaFieldsFromCategory();
  }
}

function validaCategory() {
  const category = $("#category");
  const teamSelect = $("#team");
  category.setCustomValidity("");
  teamSelect.innerHTML = '<option value="">Selecciona un equipo</option>'; //Siempre será la opción que nos aparezca en el desplegable de team.
if (category.value != "") {
  if (category.value === "1") { //Se está escribiendo por el HTML para que salga opción diferente dependiendo de la categoría seleccionada.
    teamSelect.innerHTML += '<option value="Benjamin-A">A</option>';
    teamSelect.innerHTML += '<option value="Benjamin-B">B</option>';
  } else if (category.value === "2") {
    teamSelect.innerHTML += '<option value="Alevín-A">A</option>';
    teamSelect.innerHTML += '<option value="Alevín-B">B</option>';
    teamSelect.innerHTML += '<option value="Alevín-C">C</option>';
  } else if (category.value === "3") {
    teamSelect.innerHTML += '<option value="Infantil-A">A</option>';
    teamSelect.innerHTML += '<option value="Infantil-B">B</option>';
  } else if (category.value === "4") {
    teamSelect.innerHTML += '<option value="Cadete-A">A</option>';
    teamSelect.innerHTML += '<option value="Cadete-B">B</option>';
  } else if (category.value === "5") {
    teamSelect.innerHTML += '<option value="Juvenil-A">A</option>';
    teamSelect.innerHTML += '<option value="Juvenil-B">B</option>';
    teamSelect.innerHTML += '<option value="Juvenil-C">C</option>';
  }
  muestra($("#field-team"));
}
else {
    category.setCustomValidity("Elige una opción para poder continuar.");
    category.reportValidity();
    ocultaFieldsFromTeam();
}
}


function validaTeam() {
  const equipo = $("#team");
  equipo.setCustomValidity("");
  if (equipo.value != "") {
    muestra($("#field-match"));
  } else {
    equipo.setCustomValidity("Elige una opción para poder continuar.");
    equipo.reportValidity();
    ocultaFieldsFromMatch();
  }
}

function validaMatch() {
  const category = $("#category");
  const match = $("#match");
  match.setCustomValidity("");
  if (category.value == "1" && match.value=="1" || category.value == "2" && match.value=="2" || category.value == "3" && match.value=="3" || category.value == "4" && match.value=="4" || category.value == "5" && match.value=="5") {
    //Acorde con el mensaje de error que se nos muestra, dependiendo de la categoría, se corresponde un partido. En el caso que no coincidan, no seguirá mostrando datos y le mostrará el mensaje de error.
      muestra($("#field-date"));
    }
    else {
      match.setCustomValidity("Introduce un partido válido, recuerda que debe corresponderse a la categoría indicada "+
      "Benjamín -> Algabeño-Santiponce, Alevín -> Algabeño-Bormujos, Infantil -> Algabeño-Gines, Cadete -> Algabeño-Guillena, Juvenil -> Algabeño-Cantillana");
      match.reportValidity();
      ocultaFieldsFromDate();
    }
}

function validaDate() {
  const date = $("#date");
  const category = $("#category");
  date.setCustomValidity("");
  const fechaNacimiento = new Date(date.value);
  const hoy = new Date();
  const edad = hoy.getFullYear() - fechaNacimiento.getFullYear(); //solo tenemos en cuenta el año, ya que he aporximado la edad que normalmente tienen los niños en esa categoría

  if ((category.value == "1" && edad == 9) ||
      (category.value == "2" && edad == 11) ||
      (category.value == "3" && edad == 13) ||
      (category.value == "4" && edad == 15) ||
      (category.value == "5" && edad == 18)) {
        muestra($("#field-shirt"));
  } else {
    date.setCustomValidity("Introduce una edad válida, recuerda que debe corresponderse a la categoría indicada"+
    "Benjamín -> 9, Alevín -> 11, Infantil -> 13, Cadete -> 15, Juvenil -> 18");
    date.reportValidity();
    ocultaFieldsFromShirt();
  }
}

function validaShirt() {
  const num = $("#shirt");
  num.setCustomValidity("");
  const valor = parseInt(num.value);
  if (valor >= 1 && valor <= 30) { //no nos aseguramos que no se haya escrito una letra ya que por su tipo HTML5 no deja escribir nada que no sea un número
    muestra($("#field-button"));
  } else {
    num.setCustomValidity("Introduce un número de camiseta válido (1-30)");
    num.reportValidity();
    ocultaFieldsFromButton(); //si no se valida, se oculta el botón, por lo que no te dejará enviar el formulario sin que todos los atributos estén validados.
  }
}

function enviarFormulario(e) { 
  //Esta función, mediante unas tablas de DNI que tiene asignada cada equipo, recoge el valor del dni, de la categoría y del equipo, si el dni introducido no se encuentra en la tabla salta mensaje de error, sino, salta mensaje de envío correcto. En ambos casos, la página se recarga. 
  e.preventDefault();

  const dni = $("#dni").value.toUpperCase().trim();
  const equipo = $("#team").value;

  const jugadores = {
    "Alevín-A": ["11111111A","22222222B","33333333C"],
    "Alevín-B": ["44444444D","55555555E","66666666F"],
    "Alevín-C": ["77777777G","88888888H","99999999I"],
    "Infantil-A": ["10101010A","20202020B","30303030C"],
    "Infantil-B": ["40404040D","50505050E","60606060F"],
    "Benjamin-A": ["12121212A","13131313B"],
    "Benjamin-B": ["14141414C","15151515D"],
    "Cadete-A": ["16161616A","17171717B"],
    "Cadete-B": ["18181818C","19191919D"],
    "Juvenil-A": ["20202020A","21212121B"],
    "Juvenil-B": ["22222222C","23232323D"],
    "Juvenil-C": ["24242424E","25252525F"]
  };

  if (jugadores[equipo] && jugadores[equipo].includes(dni)) {
    alert("¡Formulario enviado correctamente!"); //en este caso uso alert ya que es el último paso del formulario
  } else {
    alert("Error: el DNI no coincide con el equipo seleccionado");
  }

  location.reload(); //reinicio página
}

document.addEventListener("DOMContentLoaded", () => {
  $("#name").addEventListener("change", validaName); //blur para que el siguiente elemento se muestre tras la validación y un clic fuera de la pantalla
  $("#name").addEventListener("input", validaName); //si el valor del atributo cambia, se recoge

  $("#surname").addEventListener("change", validaSurname);
  $("#surname").addEventListener("input", validaSurname);

  $("#email").addEventListener("change", validaEmail);
  $("#email").addEventListener("input", validaEmail);

  $("#phone").addEventListener("change", validaPhone);
  $("#phone").addEventListener("input", validaPhone);

  $("#dni").addEventListener("change", validaDNI);
  $("#dni").addEventListener("input", validaDNI);

  $("#category").addEventListener("change", validaCategory); //para desplegables o fechas
  $("#category").addEventListener("input", validaCategory);

  $("#team").addEventListener("change", validaTeam); 
  $("#team").addEventListener("input", validaTeam);

  $("#match").addEventListener("change", validaMatch); 
  $("#match").addEventListener("input", validaMatch);

  $("#date").addEventListener("change", validaDate); 
  $("#date").addEventListener("input", validaDate);

  $("#shirt").addEventListener("change", validaShirt);
  $("#shirt").addEventListener("input", validaShirt);

  $("#button").addEventListener("click", enviarFormulario); //click para enviar el formulario cuando se pinche en el botón
});

