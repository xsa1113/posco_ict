var express = require('express');
var app = express.Router(); // router로 분리 -> controller 역할

//DB
var db_config = require('../config/database');
var conn = db_config.init();


// 데이터 파라미터로 받을 때 설정.
var bodyParser = require('body-parser');
app.use(bodyParser.urlencoded({extended:true}));

app.get('/bbslist', function(req,res){
    console.log('bbslist 접속 성공!');
    console.log("req.session.member: " + req.session.member);

    var choice= req.query.choice;
    var search= req.query.search;
    var pageNumber = req.query.pageNumber;

    if(pageNumber == undefined) pageNumber = 1;

    //총글의 갯수 
    var totalCount = 0;
    var sql = " SELECT IFNULL(COUNT(*),0) as cnt "
            + " FROM BBS ";
    var sqlWord = "where del = 0";
    if(choice == "title"){
        sqlWord = " WHERE del = 0 and TITLE LIKE '%" + search + "%'" ;
    }else if(choice == "content"){
        sqlWord = " WHERE del = 0 and CONTENT LIKE '%" + search + "%'" ;
    }else if(choice == "writer"){
        sqlWord = " WHERE del = 0 and ID='" + search + "' " ;
    }
    sql += sqlWord;
    console.log("sql:" + sql);

    conn.query(sql, function(err,result){
        console.log(result[0].cnt);
        totalCount = result[0].cnt;
    });

    //폐이지 계산
    var sn = pageNumber - 1; // 0 1 2
    var start = sn*10 + 1; // 1 11
    var end =(sn + 1) * 10 ; // 10 20

    sql = " SELECT SEQ, ID, REF, STEP, DEPTH, "
        + "         TITLE,CONTENT, WDATE, DEL, READCOUNT"
        + " FROM ";

    sql += " (SELECT ROW_NUMBER()OVER(ORDER BY REF DESC, STEP ASC) AS RNUM, "
          + "          SEQ, ID, REF, STEP, DEPTH,"
          + "          TITLE,CONTENT, WDATE, DEL, READCOUNT "
          + "     FROM BBS ";
          
          sqlWord = "where del = 0";
    
        
    if(choice == "title"){
        sqlWord = " WHERE del=0 and TITLE LIKE '%" + search + "%'" ;
    }else if(choice == "content"){
        sqlWord = " WHERE del = 0 and CONTENT LIKE '%" + search + "%'" ;
    }else if(choice == "writer"){
        sqlWord = " WHERE del = 0 and ID='" + search + "' " ;
    }
    sql += sqlWord;

    sql += "        ORDER BY REF DESC, STEP ASC) a";
    sql += " WHERE RNUM BETWEEN " + start + " AND " +  end;

    console.log('sql: '  + sql);

    conn.query(sql, function(err, results){
        if(err) console.log(err);

        // console.log(JSON.stringify(results));

        res.render('bbslist.ejs', {
            user:req.session.member.id,
            data : results,
            totalCount:totalCount,
            pageNumber:pageNumber,
            choice:choice,
            search:search
        });

    });

    // var sql = "select * from bbs ORDER BY REF DESC, STEP ASC";

    // conn.query(sql, function(err, results,fileds){
    //     if(err) console.log(err);
    //     //console.log("결과: " + JSON.stringify(results));

    //     res.render('./bbslist.ejs',{
    //         user:req.session.member.id,
    //         data:results
    //     });
    // })
});


app.get('/bbsdetail', function(req, res){
    console.log("/bbsdetail 접속 성공");
    console.log(req.session.member.id);

    var seq = req.query.seq;
    console.log(seq);
    
    var sql = "SELECT SEQ, ID, REF, STEP, DEPTH, TITLE, CONTENT, WDATE, DEL, READCOUNT FROM BBS WHERE SEQ = ?";
    var params = [seq];

    var sql2 = "update bbs set readcount = readcount+1 where seq = ?";

    conn.query(sql2, params, function(err, results, fileds){
        if(err) console.log("에러발생!", err);
    });


    conn.query(sql,params,function(err, results, fileds){
        if(err) console.log("에러발생!", err);
        console.log("결과 : " + JSON.stringify(results));

        res.render('bbsdetail.ejs',{
           user:req.session.member.id,
            data : results[0]
        });
    });

});

app.get('/bbswrite', function(req,res){
    //bbswrite
    console.log('/bbswrite 접속 성공');
    res.render('bbswrite.ejs',{
        user : req.session.member.id,
    });

});


app.post('/bbswriteAf', function(req,res){
    //글쓰기 작성하기 수정하고
    console.log("/bbswirteAf 접속 성공");
    console.log(req.session.member.id);

    var sql = " INSERT INTO BBS(ID,REF,STEP,DEPTH,TITLE,CONTENT,WDATE,DEL,READCOUNT) "
    + " VALUES(?,(select ifnull(max(ref),0)+1 from bbs a), 0,0,?,?, now(),0,0) ";

   var param = [req.session.member.id, req.body.title, req.body.content];

    conn.query(sql, param, function(err, result, fileds){
        if(err) console.log(err);
        // console.log(result.insertId);
        // console.log("결과 : " + JSON.stringify(result));
        console.log(result.affectedRows);
        if(result.affectedRows > 0){
            res.render('message.ejs', {proc:"bbswrite", msg:"OK"});
        }else{
            res.render('message.ejs', {proc:"bbswrite", msg:"NG"});
        }
    });
});


app.get('/bbsupdate', function(req, res){
    //update하고 -> bbsupdateAf로 보내주기
    console.log("/bbsupdate");

    var tmp = parseInt(req.query.seq);
    console.log(tmp);

    var sql = "SELECT SEQ, ID, REF, STEP, DEPTH, TITLE, CONTENT, WDATE, DEL, READCOUNT FROM BBS WHERE SEQ = ?";

    var param = [tmp];

    conn.query(sql,param,function(err,results,fileds){
        if(err) console.log("에러발생!", err);
        // console.log("결과 : " + JSON.stringify(results));
        res.render('bbsupdate.ejs',{
            user : req.session.member.id,
            data : results[0]
        });
    });
});

app.post('/bbsupdateAf',function(req,res){
    console.log("/bbsupdateAf 수정");

    var seq = req.body.seq;
    var title = req.body.title;
    var content = req.body.content;

    var sql = "update bbs set content=? , title = ?  where seq = ?"

    var param = [content, title, seq];

    conn.query(sql, param, function(err, results, fileds){
        if(err) console.log("에러발생! ", err);
        console.log("결과 : "+ JSON.stringify(results));

        if(results.affectedRows>0){
            console.log("bbsupdate수정완료");
            res.render('message.ejs', {proc:"bbsupdate", msg:"OK"});
        }else{
            res.render('message.ejs', {proc:"bbsupdate", msg:"NO"});
        }
    });
});

app.get('/bbsdelete', function(req,res){
    console.log("/bbsdelete 삭제");

    var tmp = parseInt(req.query.seq);
    console.log(tmp);

    var sql = "update bbs set del = 1 where seq=? ";

    var param = [tmp];

    conn.query(sql,param,function(err, results, fileds){
        if(err) console.log("에러발생!", err);
        console.log("결과 : " + JSON.stringify(results));

        if(results.affectedRows>0){
            console.log("bbsdelete삭제완료");
            res.render('message.ejs', {proc:"bbsdelete", msg:"OK"});
        }else{
            res.render('message.ejs', {proc:"bbsdelete", msg:"NO"});
        }
    });
});

app.get('/bbsanswer', function(req, res){
    console.log("/bbsanswer 답글");
    var tmp = parseInt(req.query.seq);
    console.log(tmp);

    var sql = "SELECT SEQ, ID, REF, STEP, DEPTH, TITLE, CONTENT, WDATE, DEL, READCOUNT FROM BBS WHERE SEQ = ?";

    var param = [tmp];

    conn.query(sql,param,function(err,results,fileds){
        if(err) console.log("에러발생!", err);
        // console.log("결과 : " + JSON.stringify(results));
        res.render('answer.ejs',{
            user : req.session.member.id,
            data : results[0]
        });
    });
});

app.post('/bbsanswerAf', function(req, res){
    console.log('/bbsanswerAf  답글  ');

    var id = req.body.id;
    var seq = req.body.seq;
    var title = req.body.title;
    var content = req.body.content;

    console.log(id);
    console.log(seq);
    console.log(title);
    console.log(content);


            var sql1  = " UPDATE BBS SET STEP= STEP +1 WHERE REF=(SELECT REF FROM(SELECT REF FROM BBS a WHERE SEQ=?) A)"
		            + "AND STEP > (SELECT STEP FROM (SELECT STEP FROM BBS b WHERE SEQ=?) B);";
		      
		    var sql2 = "INSERT INTO BBS(ID,REF,STEP,DEPTH,TITLE,CONTENT, WDATE, DEL, READCOUNT)"
		            + "VALUES (?, "
		            + "(SELECT REF FROM (SELECT REF FROM BBS a WHERE SEQ=?) A),"
		            + "(SELECT STEP FROM (SELECT STEP FROM BBS b WHERE SEQ=?) B)+1,"
		            + "(SELECT DEPTH FROM (SELECT DEPTH FROM BBS b WHERE SEQ=?) B)+1,"
		            + "?,?,NOW(),0,0);";

        console.log(sql1);
        console.log(sql2);
        
        var param1 = [seq,seq];
        var param2 = [id,seq,seq,seq,title,content];

        var formattedSql1 = conn.format(sql1, param1);
        var formattedSql2 = conn.format(sql2, param2);
        

        conn.query(formattedSql1 + formattedSql2,function(err,results,fileds){
            if(err) console.log("에러발생!", err);
            
            console.log("결과 : " + JSON.stringify(results));

            if(results[1].affectedRows>0){
                console.log("답글완료");
                res.render('message.ejs', {proc:"bbsanswer", msg:"OK"});
            }else{
                console.log("답글에러");
                res.render('message.ejs', {proc:"bbsanswer", msg:"NO"});
            }
        });

});







//웹으로 보내준다
module.exports = app;