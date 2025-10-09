function $(selector) {
    return document.querySelector(selector);
}
console.log($("#my_third_div"));
console.log($(".my_class"));
console.log($(".prueba"));






/*alert("Hello to JS");

console.log("Hola K ASE 2!");

var table = "Normal Table";
let chair = "One chair";
console.log(table);
console.log(chair);

let testBoolean = true;
console.log(testBoolean);

let testNumber = 10;
console.log(testNumber);

let testString = 'text';
console.log(testString);

let testBooleanObject = new Boolean (true);
console.log(testBooleanObject);

let testNumberObject = new Number(10);
console.log(testNumberObject);

let testStringObject = new String('text');
console.log(testStringObject.toUpperCase());

console.log(table+ ' ' + chair);

let question = `How old is ${table} ${chair}`;
console.log(question);

let operador_a = 3;
let inc = ++operador_a;
let dec = --operador_a;
console.log(operador_a);
console.log(inc);
console.log(dec);

console.log(typeof(testBoolean))

let testNull = null;
console.log(typeof(testNull));

let testUndefined;
console.log(testUndefined);

var first_array = [];
console.log(first_array);

var second_array = new Array(3);
console.log(second_array);

var third_array = new Array(3,5);
console.log(third_array);

var fourth_array = new Array(3,5,'Seville',true,third_array);
console.log(fourth_array);

console.log(third_array[1]);
console.log(fourth_array[4][0]);

console.log(fourth_array.push("Spain"));
console.log(fourth_array[5]);

fourth_array[1][2] = 3;
console.log(fourth_array);

var third_array2 = new Array(3,5,6,7);
var arrayFinal = new Array(third_array, third_array2);
console.log(arrayFinal);

//primero fila luego columna
arrayFinal[1][2] = 8;
console.log(arrayFinal);
*/


/*var third_array2 = new Array(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
for (var i=0; third_array2.length > i; i++) {
    console.log(third_array2[i]);
}*/
/*recorrer a la inversa
for (var i = third_array2.length-1;i >= 0;i--) {
    console.log("Entramos en la iteración de "+third_array2[i])
}*/
/*Forma más eficiente (en cuanto a tiempo)
var i = third_array2.length-1;
for(;i>=0;i--){
        console.log("Entramos en la iteración de "+third_array2[i])
}*/
/*third_array2.forEach(function myFunction(item) {
  console.log(item); 
});*/

/*let today = new Date();
let first_october = new Date(2025,9,1); //cambiar año o mes 
console.log(today);
console.log(first_october);
console.log(today.getDay());

if(today>first_october) {
    console.log("Today is after to first october");
}
else {
    console.log("Today is before to first october");
}*/

/*function myFirstFunction() {
    console.log('Thanks you for you click');
}

function mySecondFunction() {
    console.log('Thank you for you interest');
}

function myThirdFunction(mensaje) {
    console.log('Pesao');
    console.log(mensaje);
}

var div = document.getElementById('my_div');
div.classList.add('my_class');
console.log(div);


var div2 = document.getElementsByTagName("div");
console.log(div2);

var div3 = document.querySelector(".my_class");
console.log(div3);
//# para traerme los ids y . para traerme las clases*/


/*var numbers = [1,2,3,4];
var n_elevator_2 = numbers.map(function(n) {return n*n;});
console.log(n_elevator_2);

var n_elevator_3 = numbers.map((n) => {return n*n;});
console.log(n_elevator_3);

var n_elevator_4 = numbers.map(n => n*n);
console.log(n_elevator_4);

let numbers1 = [[1,1],[2,2],[3,3],[4,4]];
let itself = numbers1.map(([x,y]) => x*y);
console.log(itself);*/

/*$("#btn").addEventListener("click",function () {
    var input = document.createElement("input");
    console.log("input");
});*/

$("#btn").addEventListener("click", function(){
    var input = document.createElement("input");
    input.setAttribute("type","email");
    input.setAttribute("placeholder", "E-mail");
    input.setAttribute("name", "emails[]");
    $("#form").appendChild(input);
    myAlert("<h3>Add new email input</h3>");
});
function myAlert(msg) {
    var div = document.createElement("div");
    div.classList.add("alert");
    div.innerHTML = msg;
    $("body").insertBefore(div,$("body").firstChild);
    //console.log($("body").children[1]) //importante
    var close = document.createElement("span");
    close.style.float = "right";
    close.classList.add("close");
    close.innerHTML = "X";
    div.appendChild(close);
    $("body").insertBefore(div,$("body").firstChild);
    beind_close();
}

function beind_close() {
    let elements = document.querySelectorAll(".close");
    for (var i=elements.length-1;i>=0;i--) {
        let el = elements[i];
        el.addEventListener("click",function(){
            this.parentNode.style.display = "none";
        });
    }
}