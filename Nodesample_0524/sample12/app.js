// EJS - Embeded Javascript template == 파일확장자명 == *.jsp
/**
 * JSP                          EJS
 * <%! %>                       <%- %>
 * <% %>                        <% %>                        
 * <%= %>                       <%= %>
 * 
 */

var express = require('express');
var http = require('http');
var fs = require('fs');


var app = express();

var server = http.createServer(app);

app.set('views', __dirname + '/views');

var myStyle = {
    style: fs.readFileSync(__dirname + "/css/style.css", 'utf-8')
};

app.get('/', function(req,res){
    res.render('index.ejs',{
        title: 'Welcome My World',
        myCss: myStyle,
        myData : {id : "abc", pwd:"123"}
    })
});

server.listen(8090, function(){
    console.log("웹 서버 동작중...");
});