import { useEffect, useState } from "react";

const CountEffect = () => {
    const[count, setCount] = useState(1);
    useEffect(() =>{
        console.log("없음", count);
    });

    useEffect(() => {
        console.log("[]", count);
    },[]);
    useEffect(() => {
        console.log("[count]",count);
    },[count]);
    return(
        <div>
            <p>{count}</p>
            <button onClick={() => setCount(count+1)}>+</button>
            <hr></hr>
        </div>
    );
};
export default CountEffect;