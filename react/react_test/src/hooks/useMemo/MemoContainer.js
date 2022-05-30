import { useState } from "react";
import PrimaryNumber from "./PrimaryNumber";


const MemoContainer = () => {
    const [number, setNumber] = useState(0);
    const [count, setCount] = useState(0);
   
    const onChangeHandler = (e) =>{
        const eventNember = Number(e.target.value);
        setNumber(eventNember);
        
    };
    // const getPrimaryNumber = (number) => {
    //     console.log(number);
    //     let ans = 0;
    // }
    
    return(
        <div>
            <p>{count}</p>
            <button
                onClick={() => {
                    setCount(count+1);
                }}
            >
                +
            </button>
                <hr></hr>
                <input type={"number"} value={number} onChange={onChangeHandler}></input>
                <PrimaryNumber number={number}></PrimaryNumber>
        </div>
    );
};

export default MemoContainer;