import { useState } from "react";
import { Button, Spinner } from "reactstrap";
import "./ProfileBody.css";
import ProfileUpdate from "./ProfileUpdate";

const ProfileBody = ({ posts = new Array(5), follower = new Array(5), following = new Array(5), img = "/img/profile/11.jpg", name = "park" }) => {
  const [isOpen, setIsOpen] = useState(false);
  const modalClose = () => {
    setIsOpen(false);
  };
  const modalOpen = () => {
    setIsOpen(true);
  };
  console.log(posts);
  console.log(follower);

  return (
    <>
      <div className="profileBodyBox">
        <div className="profileImgBox">
          <img className="profileImg" src={img} alt="myProfileImg"></img>
        </div>
        <div className="profileTextBox">
          <div>
            {posts?.loading ? <Spinner>Loading...</Spinner> : posts.length}
            <br></br>
            게시물
          </div>
          <div>
            {follower?.loading ? <Spinner>Loading...</Spinner> : follower.follows.length}
            <br></br>
            팔로워
          </div>
          <div>
            {following?.loading ? <Spinner>Loading....</Spinner> : following.follows.length}
            <br></br>
            팔로잉
          </div>
        </div>
      </div>
      <div className="profileBodyButtonBox">
        <Button block color="light" onClick={modalOpen}>
          프로필 편집
        </Button>
        <Button block color="light">
          보관함 보기
        </Button>
      </div>
      <ProfileUpdate img={img} name={name} isOpen={isOpen} modalClose={modalClose}></ProfileUpdate>
    </>
  );
};

export default ProfileBody;
