import React, {useState} from "react";
import "../styles/Form.css";

export const Form = () => {
    const[form, setForm] = useState({
       id : "",
       password: "",
       gender: "",
       email: "",
       age: "", 
    });
    const genderList = [
        {name : "남자" , value : 1},
        {name : "여자" , value : 2},
    ];
    const onSubmit = () => {
        console.log(form);
    };
    const onChangeHandler = (e) => {
        const{name,value} = e.target;
        setForm({...form, [name]:value}); // 데이터를 가져와서 하나씩 맵핑시켜주겠다
        console.log({...form});
    };
    return (
        <div>
            <div className = "flexBox">
                <p>ID : </p>
                <input type={"text"} name="id" value={form.id} onChange={(e) => onChangeHandler(e)}></input>
            </div>
            <div className="flexBox">
                <p>password : </p>
                <input type={"password"} name="password" value={form.password} onChange={(e) => onChangeHandler(e)}></input>
            </div>
            <div className="flexBox">
                <p>성별 : </p>
                <select name="gender" onChange={(e) => onChangeHandler(e)} value={form.gender}>
                    {genderList.map((data) => (
                        <option value={data.value} key={data.name}>
                            {data.name}
                        </option>
                    ))}
                </select>
            </div>
            <div className="flexBox">
                <p>나이 : </p>
                <input name="age" type={"text"} onChange={(e) => onChangeHandler(e)} value={form.age}></input>
            </div>
            <div className="flexBox">
                <p>email :</p>
                <input name="email" type={"text"} onChange={(e) =>onChangeHandler(e)} value={form.email}></input>
            </div>

            <button onClick={onSubmit}>submit</button>
        </div>
    )
};