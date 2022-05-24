var myModule = require("./mymodule.js");

var name = myModule.name;
var age = myModule.age;

var result = myModule.add(4,6);
console.log(`${name}, ${age},${result}`);

console.log(name, age,result);