var fs = require('fs');

console.log(__dirname);

//write
/* var str = "test 테스트";
fs.writeFile(__dirname +  "/test.txt",str, function(err){
    if(err) return console.log(err);
    console.log("파일 작성완료!");
}); */

//append
/* fs.appendFile(__dirname + "/test.txt","추가문자열", function(err){
    if(err) return console.log(err);
}); */

/* var data = fs.readFileSync(__dirname + "/test.txt");
console.log(data.toString); */


//read
var data = fs.readFile(__dirname + "/test.txt", 'utf-8', function(err, data){
    if(err) return console.log(err);
    console.log(data);
});


// delete
fs.unlink(__dirname + '/test.txt', function(err){
    if(err) return console.log(err);
    console.log('파일 삭제 성공!');
});