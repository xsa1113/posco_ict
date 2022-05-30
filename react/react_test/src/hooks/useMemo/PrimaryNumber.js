import { useEffect, useState } from "react";

const PrimaryNumber = ({number}) => {
    const [ans, setAns] = useState();
    useEffect(()=>{
        console.log("effect");
        getPrimaryNumber();
    }, [number]);
    const getPrimaryNumber = (number) => {
        //소수구하는 로직

        
        let ans = 0;
        for(let i=2; i<=number; i++){
            let isPrimeNumber = true;

            for(let j=2; j<i; j++){
                if(i%j === 0){
                    isPrimeNumber = false;
                    break;
                }
            }

            if(isPrimeNumber){
                ans++;
            }
        }
        return ans;
        
    };
    getPrimaryNumber(number);

    return <p>{`소수가 ${ans}개 있습니다.`}</p>;
};
export default PrimaryNumber;