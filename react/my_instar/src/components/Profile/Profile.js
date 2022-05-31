import { useContext } from "react";
import { Container } from "reactstrap";
import { FollowContext } from "../../store/FollowContext";
import { PostContext } from "../../store/PostContext";
import { UserContext } from "../../store/UserContext";
import ProfileBody from "./ProfileBody";
import ProfileHeader from "./ProfileHeader";
import "./Profile.css";

const Profile = () => {
  const { users } = useContext(UserContext);
  const id = Number(localStorage.getItem("id"));
  const getUser = () => {
    return users.find((user) => id === user.id);
  };
  const { name, img } = getUser();
  const { posts } = useContext(PostContext);
  const { follows } = useContext(FollowContext);
  const myPosts = () => {
    return posts.filter((post) => post.userId === id);
  };
  const myFollower = () => {
    return follows.filter((follow) => follow.following === id);
  };
  const myFollowing = () => {
    return follows.filter((follow) => follow.follower === id);
  };
  return (
    <>
      <ProfileHeader name={name}></ProfileHeader>
      <Container className="ProfileContainer">
        <ProfileBody
          img={img}
          follower={myFollower()}
          following={myFollowing()}
          posts={myPosts()}
        ></ProfileBody>
      </Container>
    </>
  );
};

export default Profile;