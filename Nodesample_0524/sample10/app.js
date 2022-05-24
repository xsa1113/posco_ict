var http = require('http');
var fs = require('fs');

http.createServer(function(req,res){
    console.log("server start...")
    fs.readFile(__dirname + '/index.html',function(err, data){
        if(err) console.log(err);

        console.log('readfile process');

        res.writeHead(200, { 'Content-Type': 'text/html'});
        res.write(data);
        res.end();
    });
}).listen(8090);