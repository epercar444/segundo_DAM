function $(selector) {
  return document.querySelector(selector);
}

function muestra(elemento) {
  elemento.style.display = "block";
}

function oculta(elemento) {
  elemento.style.display = "none";
}

function validaEmail() {
  const email = $("#field-email");
  if (email.checkValidity()) {
    email.setCustomValidity("");
    email.reportValidity();
    muestra($("#field-phone"));
  } else {
    email.setCustomValidity("Introduce una dirección de correo correcta");
    email.reportValidity();
    oculta($("#field-phone"));
  }
}

function validaPhone() {
  const phone = $("#field-phone");
  if (phone.checkValidity()) {
    muestra($("#field-dni"));
  } else {
    phone.setCustomValidity("Introduce un número de teléfono correcto");
    phone.reportValidity();
    oculta($("#field-dni"));
  }
}

function validaDNI() {
  const dni = $("#field-dni");
  var comprobarDNI = /^[0-9]{8}[A-Z]$/;  
  if (comprobarDNI.test(dni.value)) {
    muestra($("#field-date"));
  } else {
    dni.setCustomValidity("Introduce un DNI correcto");
    dni.reportValidity();
    oculta($("#field-date"));
  }
}

document.addEventListener("DOMContentLoaded", () => {
  $("#field-email").addEventListener("blur", validaEmail);
  $("#field-email").addEventListener("input", validaEmail);

  $("#field-phone").addEventListener("blur", validaPhone);
  $("#field-phone").addEventListener("input", validaPhone);

  $("#field-dni").addEventListener("blur", validaDNI);
  $("#field-dni").addEventListener("input", validaDNI);

  // Suponiendo que tienes la función validaDate definida
  // $("#date").addEventListener("blur", validaDate);
});
