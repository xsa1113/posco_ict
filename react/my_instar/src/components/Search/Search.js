import { useContext, useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";

import { PostContext } from "../../store/PostContext";
import { selectOtherPost, selectPostsByKey } from "../../store/posts";
import { getPostByOther } from "../../store/postsApi";
import { UserContext } from "../../store/UserContext";
import { selectUserByKey } from "../../store/users";
import Posts from "../Posts/Posts";
import SearchBar from "./SearchBar";

const Search = () => {
  const dispatch = useDispatch();
  const otherPosts = useSelector((state) => state.posts.otherPosts);

  useEffect(() => {
    dispatch(selectOtherPost());
    setSearchPost(otherPosts);
  }, []);
  console.log("다른사람포스트");
  console.log(otherPosts);
  const [searchPost, setSearchPost] = useState(otherPosts);
  const [searchKey, setSearchKey] = useState();

  const onSubmitSearch = async (e) => {
    e.preventDefault();
    //action

    const findUserId = await dispatch(selectUserByKey(searchKey)).unwrap();
    await dispatch(selectPostsByKey({ searchKey, userId: findUserId }));
  };

  return (
    <div>
      <SearchBar searchKey={searchKey} setSearchKey={setSearchKey} onSubmitSearch={onSubmitSearch}></SearchBar>
      <Posts posts={otherPosts.posts} postState={otherPosts}></Posts>
    </div>
  );
};
export default Search;
