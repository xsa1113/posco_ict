const Second= ({name, setName}) => {
    return (
        <>
            <p>{`Second : ${name}`}</p>
            <button onClick={() => {
                console.log(name);
                setName("reactkim");
            }}
            >
                Second name set react
            </button>
        </>
    );
};
export default Second;