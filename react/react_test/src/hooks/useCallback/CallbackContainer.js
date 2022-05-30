import CallbackPrint from "./CallbackPrint";

const CallbackContainer = () =>{
    const a = 50;
    const b = 20;
    const [c, setC] = useState(0);
    const addCallback = useCallback(() => a + b + c, [onChange]);

    return (
        <div>
            <input type="number" value={c} onChange={(e) => setC(Number(e.target.value))}></input>
            <CallbackPrint a={a} b={b} c={c} addCallback={addCallback}></CallbackPrint>
        </div>
    );
};
export default CallbackContainer;