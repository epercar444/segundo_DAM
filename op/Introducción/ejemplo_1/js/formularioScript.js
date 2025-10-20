
//# -> getElementbyId(); . -> getElementByClase
function  $(selector) {
    return document.querySelector(selector);
}

function  muestra(elemento) {
    return elemento.style.display = "block";
}

function validaEmail()  {
    var email = $("#field-email");
    var email_guardado = email.value;
    if (email.checkValidity()) {
        muestra($("#field-phone"))
    }
    else {
        email.setCustomValidity ("Introduce una dirección de correo correcta");
    }
}
