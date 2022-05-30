import logo from './logo.svg';
import './App.css';
import { useState } from "react";

function App() {

  const deleteBtn = index =>{
    setToDos((curToDos) => curToDos.filter((_, curIndex) => curIndex !== index));
  };
  
  const [toDo, setToDo] = useState(""); // todo리스트를 받을 값 준ㅂ비
  const [toDos, setToDos] = useState([]); // 비어있는 배열값
const onChange = (event) => setToDo(event.target.value); // todo와연결된값
const onSubmit = (event) =>{
  event.preventDefault();
  if(toDo == ""){
    return;
  }

  
  //state(toDo,toDos는 )는 절대 직접적으로 값을 설정하지않는다 
  //그렇기에 setTodos로 값을 설정해준다
  
  // todo 추가 ...파라미터 -> 이전값을 가져온다
  // 새로운 toDo를 리턴하는거임 다 더해서
  setToDos(currentArray => [toDo, ...currentArray ]);
  setToDo("");
};
console.log(toDos);
  return (
    <div>
      <h1>My To dos({toDos.length})</h1>
      <form onSubmit={onSubmit}>
          <input
            onChange={onChange}
            value ={toDo}
            type="text"
            placeholder='writer your to do..'
            />
          <button>Add to Do</button>
      </form>
      <hr />
      <ul>
      {toDos.map((item, index) =>(
      <li key={index}>
        {item}
        <button onClick={() =>deleteBtn(index)}>삭제</button>
        </li>
      ))}
      </ul>
    </div>
  );
}

export default App;
