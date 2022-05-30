import { useState } from "react";
import Second from "./Second";

const First = () => {
    const [name, setName] = useState("hello");

    return(
        <>
            <p>{`first : ${name}`}</p>
            <button onClick={() =>{
                setName("world");
            }}
            >
                first name set World
            </button>
            <Second name={name} setName={setName}></Second>
        </>
    );
};

export default First;