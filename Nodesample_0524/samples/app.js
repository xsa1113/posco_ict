var express = require('express');
var app = express();
var path = require('path');

// router 등록
var member = require('./routers/member');
app.use(member);
var bbs = require('./routers/bbs');
app.use(bbs);

// views(html, ejs) 폴더를 인식
app.set("views", __dirname + "/views");

// ejs.를 사용하겠다
app.engine('html',require('ejs').renderFile);
app.set('view engine', 'ejs');

//public 폴더의 추가
app.use(express.static(path.join(__dirname, 'public')));


var port = 8090
var server = app.listen(8090,function(){
    console.log(`server start... port : ${port}`);
});