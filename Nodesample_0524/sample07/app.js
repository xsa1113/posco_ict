//http, express 

var http = require('http');

// server object를 생성
var server = http.createServer();

var port = 8090;

server.listen(8090,function(){
    console.log("web server start... : %d", port);
});

// client connect event 처리
server.on('connection', function(socket){

    var addr = socket.address();
    console.log("클라이언트가 접속했습니다 : %s , %d", addr.address,addr.port);
});

// client request event 처리
server.on("request",function(req,res){
    console.log("클라이언트로부터 요청이 들어왔습니다");
    console.dir(req);    
});

// server close
server.on('close', function(){
    console.log("server on close");
});


/* server.close(function(){
    console.log("server 가종료됩니다");
}) */
