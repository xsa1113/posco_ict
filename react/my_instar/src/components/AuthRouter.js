import { useContext, useEffect } from "react";
import { Users } from "./Login/User";
import { useLocation, useNavigate } from "react-router-dom";
import { UserContext } from "../store/UserContext";
import { useDispatch } from "react-redux";
import { BiCoffeeTogo } from "react-icons/bi";
import { AiTwotoneHome } from "react-icons/ai";
import { loginCheck } from "../store/users";
const AuthRouter = () => {
  // const { users } = useContext(UserContext);
  // context 대신에 redux를 사용한다
  // redux함수를 쓰려면 항상 useDispatch안에서 사용
  // unwrap은 리턴값을 받으려고 상요
  const dispatch = useDispatch();
  const navigate = useNavigate();
  const location = useLocation();

  useEffect(() => {
    //context사용할 때 사용
    // const id = localStorage.getItem("id");
    // const findUser = users.find((data) => data.id == Number(id));
    // if (!findUser || !id) {
    //   const from = location.pathname === "/login" || location.pathname === "/join" ? location.pathname : "/login";
    //   navigate(from);
    // } else {
    //   const from = location.pathname || "/";
    //   navigate(from === "/login" || from === "/join" ? "/" : from);
    // }

    loginCheckFunc();
  }, []);
  const loginCheckFunc = async () => {
    const isLogin = await dispatch(loginCheck()).unwrap();
    isLogin ? toGo() : toHome();
  };
  const toHome = () => {
    const from = location.pathname === "/login" || location.pathname === "/join" ? location.pathname : "/login";
    navigate(from);
  };
  const toGo = () => {
    const from = location.pathname || "/";
    navigate(from === "/login" || from === "/join" ? "/" : from);
  };
  return <></>;
};
export default AuthRouter;
