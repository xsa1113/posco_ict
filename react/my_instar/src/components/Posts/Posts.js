import { useState } from "react";
import "./Posts.css";
import PostDetail from "./PostDetail";
const Posts = ({ posts, name, img, deletePost }) => {
  const [isOpen, setIsOpen] = useState(false);
  const [clickPost, setClickPost] = useState();
  const openModal = (post) => {
    setClickPost(post);
    setIsOpen(true);
  };
  const closeModal = () => {
    setClickPost();
    setIsOpen(false);
  };
  const onClickDelete = (postId) => {
    deletePost(postId);
    setIsOpen(false);
    // closeModal();
  };
  console.log(name);
  return (
    <div className="Posts">
      {posts?.map((post) => (
        <div className="PostsImgBox" onClick={() => openModal(post)} key={post.id}>
          <img className="PostsImg" key={post.id} src={post.img} alt={post.content}></img>
        </div>
      ))}
      {clickPost ? (
        <PostDetail
          // name={name}
          // img={img}
          isOpen={isOpen}
          clickPost={clickPost}
          closeModal={closeModal}
          onClickDelete={onClickDelete}
        ></PostDetail>
      ) : null}
    </div>
  );
};

export default Posts;
