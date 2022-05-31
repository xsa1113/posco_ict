import { BrowserRouter, Route, Routes } from "react-router-dom";
import BootstrapLogin from "./components/Login/BootstrapLogin";
import Login from "./components/Login/Login";
import Main from "./components/Main";
import Page404 from "./components/Page404";
import Join from "./components/Join/Join";
import { Users } from "./components/Login/User";
import { useState } from "react";
import { UserContext } from "./store/UserContext";
import Layout from "./components/Layout/Layout";

function App() {
  const [users, setUsers] = useState(Users);
  const insertUsers = (user) => {
    const newUser = { ...user, userId: user.id, id: users.length };
    // console.log([user.id]);
    setUsers([...users, newUser]);
  };

  return (
    <UserContext.Provider value={{ users, insertUsers }}>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Layout></Layout>}>
            <Route index path="/" element={<Main></Main>}></Route>
            <Route path="shopping" element={<Main></Main>}></Route>
          </Route>
          <Route
            path="/login"
            element={<BootstrapLogin></BootstrapLogin>}
          ></Route>
          <Route path="/join" element={<Join></Join>}></Route>
          <Route path="/*" element={<Page404></Page404>}></Route>
        </Routes>
      </BrowserRouter>
    </UserContext.Provider>
  );
}

export default App;
