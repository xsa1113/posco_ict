var express = require('express');

var app = express();

//데이터 파라미터로 받을 떄 설정 

var bodyParser = require('body-parser');
const { send } = require('process');
const {response} = require('express');
app.use(bodyParser.urlencoded({extended:true}));


const mysql = require('mysql');

// 연결해줄 conn객체 만들기 
const conn ={
    host: 'localhost',
    port: '3306',
    user: 'root',
    password: '1234',
    database:'mydb'
};


// 연결해줄 커넥션만들기 
var connection = mysql.createConnection(conn);

// 연결해주기 mysql
connection.connect();

// backend는 8090 , front는 8080
app.listen(8090,function(){
    console.log("웹서버 8090 작동중 ... ");
});


app.post("/regist", function(req,res){
    console.log('regist 접속 성공!');
    console.log(req.body.writer);
});