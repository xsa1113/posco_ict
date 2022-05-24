var express = require('express');
var http = require('http');
var fs = require('fs');

var app = express();

//app 과 server를 연동하는 법 
// http -> 서버를 확장할 수 있음 
var server = http.createServer(app);

app.get("/", function(req,res){    
    fs.readFile(__dirname + '/index.html',function(err, data){
            if(err) console.log(err);
    
            console.log('readfile process');
    
            res.writeHead(200, { 'Content-Type': 'text/html'});
            res.write(data);
            res.end();
    });
});



server.listen(8090, function(){
    console.log('웹 서버 동작중 ');
});