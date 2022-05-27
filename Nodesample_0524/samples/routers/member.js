var express = require('express');
var app = express.Router(); // router로 분리 -> controller 역할

//DB
var db_config = require('../config/database');
var conn = db_config.init();
var session = require('express-session');

var cookieParser = require('cookie-parser');

app.use(cookieParser());

app.use(session({
    secret:'keyboard cat',
    resave: false,
    saveUninitialized:true
}));


// 데이터 파라미터로 받을 때 설정.
var bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({extended:true}));

app.get('/login',function(req,res){
    console.log('login 접속 성공!');

    //뿌리기
    res.render('login.html');
});

app.get('/regi',function(req,res){
    console.log('regi 접속 성공!');
    res.render('regi.html');
});


app.post('/checkId', function(req, res){
    console.log("checkId 접속 성공!");
    console.log(req.body.id);

    //sql 문은 json으로 반환해준다
    var sql ="select count(*) as cnt from member where id=?";
    var param = [req.body.id];

    conn.query(sql, param, function(err, result, fields){
        if(err) console.log(err);

        console.log("결과:" + JSON.stringify(result[0]) );

        if(result[0].cnt == 0){
            //없는것
            res.send({result:'OK'});
        }else{
            res.send({result:'NO'});
        }
    });
});

app.post('/regiAf',function(req,res){
    console.log("regiaf 접속 성공");
    // console.log(req.body.id);
    // console.log(req.body.pwd);

    var sql = " INSERT INTO MEMBER(ID,PWD,NAME,EMAIL,AUTH) "
    + " VALUES(?,?,?,?,3) ";
    var param = [req.body.id, req.body.pwd, req.body.name, req.body.email];

    conn.query(sql,param, function(err,result,fields){
        if(err) console.log(err);
        console.log(result.insertId);
        console.log("결과 : " + JSON.stringify(result));

        if(result.affectedRows>0 ){
            
            res.send({result:'OK'});
        }else{
            
            res.send({result:'NO'});
        }

    })

});

app.post("/loginAf",function(req,res){
    console.log("/loginAf 접속 성공!");  

    var id = req.body.id;
    var pwd = req.body.pwd;

    var sql = "select id, name, email from member where id=? and pwd=?";
    var params = [id, pwd];

    conn.query(sql,params, function(err, result,fileds){
        if(err) console.log("에러발생!", err);
        console.log("결과 : " + JSON.stringify(result));
        console.log(result.length);

        if(result.length >0){
            console.log(result[0].id);

            //
            req.session.member = result[0];

            console.log("req.session.member: " + req.session.member);
            console.log(req.session.member.name);
            
            res.render('message.ejs', {proc:"login", msg:"OK"});
        }else{
            res.render('message.ejs', {proc:"login", msg:"NG"});
        }

    });

});

//웹으로 보내준다
module.exports = app;