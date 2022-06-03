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
import Profile from "./components/Profile/Profile";
import { Follow } from "./data/Follow";
import { Post } from "./data/Post";
import { PostContext } from "./store/PostContext";
import { FollowContext } from "./store/FollowContext";
import Search from "./components/Search/Search";
import { useDispatch } from "react-redux";
import { selectMyPost } from "./store/posts";

function App() {
  const [users, setUsers] = useState(Users);
  const insertUsers = (user) => {
    const newUser = { ...user, userId: user.id, id: users.length };
    // console.log([user.id]);
    setUsers([...users, newUser]);
  };
  const updateUsers = (user) => {
    const id = Number(localStorage.getItem("id"));
    const { img, name } = user;
    const findUsersIndex = users.findIndex((user) => user.id === id);
    if (findUsersIndex === -1) {
      console.error("not found");
      return;
    }
    const newUsers = [...users];
    newUsers.splice(findUsersIndex, 1, { ...users[findUsersIndex], name, img });
    setUsers(newUsers);
  };

  const [posts, setPosts] = useState(Post);
  const insertPost = (post) => {
    const newPost = {
      ...post,
      userId: Number(localStorage.getItem("id")),
      id: posts.length,
    };
    setPosts([...posts, newPost]);
  };
  const deletePost = (postId) => {
    const delPosts = posts.filter((post) => post.id != postId);
    setPosts(delPosts);
  };
  const [follows, setFollows] = useState(Follow);
  const insertFollow = (follwerId) => {
    const newFollow = {
      following: Number(localStorage.getItem("id")),
      follower: follwerId,
    };
    setFollows([...follows, newFollow]);
  };

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Layout></Layout>}>
          <Route index element={<Main></Main>}></Route>
          <Route path="search" element={<Search></Search>}></Route>
          <Route path="shopping" element={<Main></Main>}></Route>
          <Route path="profile" element={<Profile></Profile>}></Route>
        </Route>
        <Route path="/login" element={<BootstrapLogin></BootstrapLogin>}></Route>
        <Route path="/join" element={<Join></Join>}></Route>
        <Route path="/*" element={<Page404></Page404>}></Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
