// url

var url = require('url'); // require = import , npm install url

var addr = "http://localhost:8080/default.html?year=2022&month=february";

var q = url.parse(addr, true);
console.log(q.host);
console.log(q.pathname);
console.log(q.search);

var qdata = q.query;
console.log(qdata);
console.log(qdata.month);

var praseObject = url.parse('https://www.google.com/search?q=iphone&oq=iphone&aqs=chrome..69i57j69i60.2015j0j4&sourceid=chrome&ie=UTF-8');
console.log(praseObject);

console.log(url.format(praseObject));

// query 만을 취득
var querystring = require('querystring');
var param = querystring.parse(praseObject.query);

console.log(param);