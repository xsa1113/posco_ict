const mysql = require('mysql');

//mysql 접속설정
const conn ={
    host: 'localhost',
    port: '3306',
    user: 'root',
    password: '1234',
    database:'mydb'
};

var connection = mysql.createConnection(conn);

connection.connect();

//select
/* var sql = "select * from tablesample";

//query실행
connection.query(sql, function(err,result,fields){
    if(err) console.log(err);

    console.log("접속성공");

    console.log(JSON.stringify(result));
    console.log(result[0].id);
}); */

//insert
/* var sql = "INSERT INTO TABLESAMPLE(ID,NAME) "
        + "VALUES('bcd','성춘향')";

connection.query(sql, function(err){
    if(err) console.log(err);

    console.log("추가성공");
}); */

var sql = "INSERT INTO TABLESAMPLE(ID,NAME) "
        + "VALUES(?,?)";

var param = ['cde','정수동'];

connection.query(sql, param, function(err){
    if(err) console.log(err);
    

    console.log("추가성공");
});
