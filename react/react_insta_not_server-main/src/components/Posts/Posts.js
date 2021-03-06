import { unwrapResult } from "@reduxjs/toolkit";
import { useContext, useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useLocation } from "react-router-dom";
import { Button, Container, Modal, Spinner } from "reactstrap";
import { IMG_PATH } from "../../http/CustomAxios";
import {
  deleteFollow,
  insertFollowing,
  selectMyFollowingOne,
} from "../../store/follows";
import { deletePost, selectMyPost, selectOtherPost } from "../../store/posts";
import { UserContext } from "../../store/UserContext";
import { selectUserById } from "../../store/users";
import "./Posts.css";
const Posts = ({ postState, posts }) => {
  const [isOpen, setIsOpen] = useState(false);
  const [clickPost, setClickPost] = useState();
  const [postUser, setPostUser] = useState();
  const dispatch = useDispatch();
  const location = useLocation();
  const openModal = (post) => {
    dispatch(selectUserById(post.userId))
      .unwrap()
      .then((result) => {
        setPostUser(result);
      })
      .finally(() => {
        setClickPost(post);
        setIsOpen(true);
      });
  };
  const closeModal = () => {
    setClickPost();
    setIsOpen(false);
  };
  const onClickDelete = async (postId) => {
    await dispatch(deletePost(postId));
    await dispatch(
      location.pathname === "/profile" ? selectMyPost() : selectOtherPost()
    );
    setIsOpen(false);
  };

  return (
    <div className="Posts">
      {postState.loading ? (
        <Spinner>Loading...</Spinner>
      ) : (
        posts?.map((post) => (
          <div
            className="PostsImgBox" //
            onClick={() => openModal(post)}
            key={post.id}
          >
            <img
              className="PostsImg" //
              key={post.id}
              src={`${IMG_PATH}${post.img}`}
              alt={post.content}
            ></img>
          </div>
        ))
      )}
      {clickPost ? (
        <PostDetail
          isOpen={isOpen} //
          clickPost={clickPost}
          closeModal={closeModal}
          onClickDelete={onClickDelete}
          user={postUser}
        ></PostDetail>
      ) : null}
    </div>
  );
};
export default Posts;

const PostDetail = ({ isOpen, clickPost, closeModal, onClickDelete, user }) => {
  const myId = Number(useSelector((state) => state.users.myId));
  const dispatch = useDispatch();
  const [isMyFollowing, setIsMyFollowing] = useState(false);
  const postFollowData = () => {
    dispatch(selectMyFollowingOne(user.id))
      .unwrap()
      .then((res) => {
        console.log(res);
        setIsMyFollowing(res);
      });
  };
  useEffect(() => {
    postFollowData();
  }, [user]);

  const unFollow = async () => {
    await dispatch(deleteFollow(user.id));
    await postFollowData();
  };
  const follow = async () => {
    await dispatch(insertFollowing(user.id));
    await postFollowData();
  };
  return (
    <Modal isOpen={isOpen} fullscreen toggle={closeModal}>
      <div className="PostsModalHeader">
        <Button close onClick={closeModal}></Button>{" "}
        <div>
          {user.name}
          <strong>?????????</strong>
        </div>
        {user.id === myId ? (
          <Button
            color="danger" //
            outline
            onClick={() => onClickDelete(clickPost.id)}
          >
            ????????????
          </Button>
        ) : (
          <div></div>
        )}
      </div>
      <Container>
        <div className="PostsBody">
          <div className="PostsBodyHeader">
            <div className="PostsBodyHeaderImgBox">
              <img
                className="PostsBodyHeaderImg" //
                src={user.img}
                alt="userImg"
              ></img>
            </div>
            {user.name}
            {user.id === myId ? (
              <></>
            ) : !isMyFollowing ? (
              <Button onClick={follow} outline>
                ?????????
              </Button>
            ) : (
              <Button onClick={unFollow} outline>
                ????????????
              </Button>
            )}
          </div>
          <img
            className="PostsBodyImg"
            src={clickPost?.img} //
            alt="postimg"
          ></img>
          <p>{clickPost?.content}</p>
        </div>
      </Container>
    </Modal>
  );
};
