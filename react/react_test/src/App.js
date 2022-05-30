import logo from './logo.svg';
import './App.css';
// import MemoContainer from './hooks/useMemo/MemoContainer';
import CallbackPrint from './hooks/useCallback/CallbackPrint';

// import Hello from './component/Hello';
// import Hi from './component/Hi';
// import Title from './component/Title';
// import Count from './component/Count';
// import Clock from './component/Clock';

// import { ThemeContext } from './component/themeTest/ThemeContext';
// import { themes } from './component/themeTest/Themes';
// import Container from './component/themeTest/Container';
// import { useState } from 'react';

// import { Form } from './component/Form';
// import Basic from './component/Basic';
// import First from './component/First';
// import Table from './component/understanding/Table';
// import React, { useEffect, useState, createContext, useContext } from "react";
// import CountEffect from './hooks/useEffect/CountEffect';



function App() {
    //초기예제
  // const [time,setTime] = useState(new Date().toLocaleString());
  // setInterval(() =>{
  //   setTime(new Date().toLocaleString());
  // },1000);

  //색변경예제
  // const [isDark, setIsDark] = useState(true);
  // const changeMode = () => {
  //   setIsDark(!isDark);
  // };

  return (
    <div className="App">
      <header className='App-header'>
        <CallbackPrint></CallbackPrint>
        {/* <MemoContainer></MemoContainer> */}
        {/* <ThemeContext.Provider value={{themes : isDark ? themes.dark : themes.light, changeMode}}>
          <Container setIsDark={setIsDark} isDark={isDark}></Container>
        </ThemeContext.Provider> */}
        {/* <CountEffect></CountEffect> */}
        {/* <Table></Table> */}
        {/* <First></First> */}
        {/* <Basic></Basic> */}
        {/* <Form></Form> */}
        {/* <Hi></Hi>
        <Hello></Hello>
        <Title title="hello" name = "react">
          <Title title="pppp" name="aaaa"></Title>
        </Title>
        <Title title="hi" name="react1"></Title>
        <Count></Count>
        <Clock time={time}></Clock> */}
      </header>
    </div>
  );
}

export default App;
