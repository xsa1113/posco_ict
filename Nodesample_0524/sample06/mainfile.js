// event(=사건)
// event -> listener(함수 ) callback

var events = require('events');

var eventEmitter = new events.EventEmitter();

//event handler 생성
/* var myEventHander = function(){
    console.log('event 실행');
} */


/* //event handler 할당
eventEmitter.on("scream",myEventHander);

// event 발생
eventEmitter.emit('scream');

setTimeout(function(){
    console.log("2초후에 이벤트 전달 시도");

    eventEmitter.emit('scream');
},2000); */

var connectHandler = function connected(){
    console.log('connection 성공~'); //3번
    eventEmitter.emit("data_received"); //4번
}

eventEmitter.on('connection', connectHandler); //2번

eventEmitter.on('data_received', function(){
    console.log('data recevied 성공!'); // 5번
});

eventEmitter.emit('connection'); // 1번 수행