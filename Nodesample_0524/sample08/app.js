var http = require('http');
const { traceDeprecation } = require('process');

var server = http.createServer();

var port = 8090;

server.listen(port, function(){
    console.log('웹 서비스가 시작되었습니다 : %d', port);
})

server.on('connection', function(socket){
    var addr = socket.address();

});

server.on('request', function(req,res){
    console.log('클라이언트 요청이 들어왔습니다');
    res.writeHead(200,{"content-Type": "text/html; charset=utf-8"});
    res.write("<!DOCTYPE html>");
    res.write("<html>");
    res.write("<head>");
 
    res.write("<title>응답페이지</title>");

    res.write("</head>");

    res.write("<body>");
    res.write("<h1> node.js로부터 응답 html 코드</h1>");

    res.write("</body>");
    res.write("</html>");
    res.end();

});