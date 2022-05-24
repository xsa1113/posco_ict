const foo = require('./module/exportfile.js');

console.log(foo);
console.log(foo.a);

var calc = require('./calculator.js');
console.log(`calc.add 호출 ${calc.add(3,4)}`);

var calcM = require('./calcModule');

let v = calcM.multi(5,8);
console.log(v);