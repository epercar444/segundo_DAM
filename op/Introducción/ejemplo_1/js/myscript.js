//alert("Hello to JS");

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

//primero final luego columna
arrayFinal[1][2] = 8;
console.log(arrayFinal);