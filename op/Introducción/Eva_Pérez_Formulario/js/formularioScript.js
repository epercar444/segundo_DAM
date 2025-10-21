function $(selector) {
  return document.querySelector(selector);
}

function muestra(elemento) {
  elemento.style.display = "block";
}

function oculta(elemento) {
  elemento.style.display = "none";
}

function validaName() {
  const name = $("#name");
  name.setCustomValidity(""); //borramos errores anteriores

  if (name.value.length > 2) {
    muestra($("#field-surname"));
  } else {
    name.setCustomValidity("Introduce un nombre correcto");
    name.reportValidity();
    oculta($("#field-surname"));
  }
}

function validaSurname() {
  const surname = $("#surname");
  surname.setCustomValidity("");
  const parts = surname.value.trim().split(" ");

  if (parts.length === 2 && parts[1] !== "") {
    muestra($("#field-email"));
  } else {
    surname.setCustomValidity("Introduce unos apellidos correctos");
    surname.reportValidity();
    oculta($("#field-email"));
  }
}

function validaEmail() {
  const email = $("#email");
  email.setCustomValidity("");

  if (email.checkValidity()) {
    muestra($("#field-phone"));
  } else {
    email.setCustomValidity("Introduce un email válido");
    email.reportValidity();
    oculta($("#field-phone"));
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
    oculta($("#field-dni"));
  }
}

function validaDNI() {
  const dni = $("#dni");
  const regex = /^[0-9]{8}[A-Z]$/;
  dni.setCustomValidity("");

  if (regex.test(dni.value.toUpperCase())) {
    muestra($("#field-category"));
  } else {
    dni.setCustomValidity("Introduce un DNI correcto");
    dni.reportValidity();
    oculta($("#field-category"));
  }
}

function validaCategory() {
  const category = $("#category");
  const teamSelect = $("#team");
  category.setCustomValidity("");

  muestra($("#field-team"));

  teamSelect.innerHTML = '<option value="">Selecciona un equipo</option>'; //introducimos en el html

  if (category.value === "1") {
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

  oculta($("#field-match"));
}

function validaTeam() {
  const equipo = $("#team").value;

  if (equipo !== "") {
    muestra($("#field-match"));
  } else {
    oculta($("#field-match"));
  }
}

function validaMatch() {
  muestra($("#field-date"));
}

function validaDate() {
  const date = $("#date").value;
  const category = $("#category").value;

  if (!date) {
    oculta($("#field-shirt"));
    return;
  }

  const fechaNacimiento = new Date(date);
  const hoy = new Date();
  const edad = hoy.getFullYear() - fechaNacimiento.getFullYear(); //solo tenemos en cuenta el año, ya que he aporximado la edad que normalmente tienen los niños en esa categoría

  if ((category === "1" && edad === 9) ||
      (category === "2" && edad === 11) ||
      (category === "3" && edad === 13) ||
      (category === "4" && edad === 15) ||
      (category === "5" && edad === 18)) {
    muestra($("#field-shirt"));
  } else {
    oculta($("#field-shirt"));
  }
}

function validaShirt() {
  const num = $("#shirt");
  num.setCustomValidity("");
  const valor = parseInt(num.value);

  if (valor >= 1 && valor <= 30) {
    muestra($("#field-button"));
  } else {
    num.setCustomValidity("Introduce un número de camiseta válido (1-30)");
    num.reportValidity();
    oculta($("#field-button"));
  }
}

function enviarFormulario(e) {
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
    alert("¡Formulario enviado correctamente!");
  } else {
    alert("Error: el DNI no coincide con el equipo seleccionado");
  }

  location.reload();
}

document.addEventListener("DOMContentLoaded", () => {
  $("#name").addEventListener("blur", validaName);
  $("#name").addEventListener("input", validaName);

  $("#surname").addEventListener("blur", validaSurname);
  $("#surname").addEventListener("input", validaSurname);

  $("#email").addEventListener("blur", validaEmail);
  $("#email").addEventListener("input", validaEmail);

  $("#phone").addEventListener("blur", validaPhone);
  $("#phone").addEventListener("input", validaPhone);

  $("#dni").addEventListener("blur", validaDNI);
  $("#dni").addEventListener("input", validaDNI);

  $("#category").addEventListener("change", validaCategory);
  $("#category").addEventListener("input", validaCategory);

  $("#team").addEventListener("change", validaTeam);
  $("#team").addEventListener("input", validaTeam);

  $("#match").addEventListener("change", validaMatch);
  $("#match").addEventListener("input", validaMatch);

  $("#date").addEventListener("change", validaDate);
  $("#date").addEventListener("input", validaDate);

  $("#shirt").addEventListener("blur", validaShirt);
  $("#shirt").addEventListener("input", validaShirt);

  $("#button").addEventListener("click", enviarFormulario);
});
