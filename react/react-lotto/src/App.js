import './App.css';
import { useState } from 'react';
let count = 0;
let index = 0;
function App() {
  const [students, setStudents] =useState(new Array(45).fill(1).map((data,i)=>{
    return i+1
  })); 
  const [teams,setTeams] = useState([[],[],[],[],[]]);
  const max = 6;

  // const getRandom = (min, max) => Math.floor(Math.random() * (max - min) + min);
  //초기화 함수 만들기
  const init = (setTeams) =>{
    setTeams.fill(1);
  }

  const pickStudentRandom = ()=>{
    const randomStudent = parseInt(Math.random()*students.length);
    pickStudent(students[randomStudent])
  }
  const pickStudent =(i)=>{
    setStudents(students.filter(data=>data!==i));
    if(count===max) {
      index = index+1;
      count = 0;
      init;
    } 
    const newTeams = [...teams];
    newTeams[index].push(i);
    setTeams(newTeams)
    count = count+1;
  } 
  return (
    <div className="App">
      <table>
        {teams.map((team,i)=>(
        <tr>
          <td>{team.map(student=>`${student},`)}</td>
        </tr>
        ))}
        
      </table>
          <button onClick={pickStudentRandom}>추첨</button>
    </div>
  );
}

export default App;
