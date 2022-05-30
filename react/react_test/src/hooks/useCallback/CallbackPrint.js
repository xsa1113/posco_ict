const CallbackPrint = ({a,b,c, addCallback}) => {
    return (
        <div>
            <p>{`${a} ${b} ${c} ${addCallback()}`}</p>
        </div>
    );
};

export default CallbackPrint;