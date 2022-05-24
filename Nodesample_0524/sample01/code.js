//변수
let a = 10;
var str = "타이거즈";

console.log("%d",a);
console.log("%s",str);
console.log("hello " + str + " node js");

//object
var Person = {}

Person['age'] = 25;
Person['name'] = '홍길동';
Person.mobile = '010-1234-5678';

console.log("나이 : %d", Person.age);
console.log("나이 : %d", Person['age']);
console.log("이름 : %s", Person.name);
console.log("핸드폰: %s", Person['mobile']);


// function
function mul(a, b){
    return a * b;
}

var c = mul(3,7);
console.log("%d * %d = %d",3,4,c);

// object(=class)
var Human = {
    age: 16,
    name : '성춘향',
    add:function(a,b){
        return a + b;
    }
}

console.log("더하기 : %d", Human.add(7,3));
console.log("이름 : %s", Human.name);

// class == object
class Member{
    constructor(age, name){
        this.age = age;
        this.name = name;
    }
    multi(a,b){
        return a*b;
    }
    print(){
        console.log(`${this.age}살 ${this.name}입니다`);
    }
}

var mem = new Member(16, "성춘향");
console.log("나이 :%d", mem.age);
console.log(`나이 : ${mem.age}`);

console.log("이름 : %s", mem.name);
console.log("%d", mem.multi(3,7));

var User = [
    {name : '홍길동', age:24},
    {name : '성춘향', age:14}
]

console.log('첫번째사람 : %s, %d', User[0].name, User[0].age);
console.log('두번째사람 : %s, %d', User[1].name, User[1].age);

//데이터를 추가 
User.push({'name' : "일지매", 'age':22});
console.log(User.length);

//람다식 
var func  = function(a,b){
    return a+ b;
}

User.push(func);
console.log("함수 : %d", User[3](3,4));

