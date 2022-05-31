import "./ProfileHeader.css";
import { GoDiffAdded } from "react-icons/go";
import { AiOutlineMenu } from "react-icons/ai";
const ProfileHeader = ({ name }) => {
  return (
    <div className="ProfileHeaderBox">
      <div>
        <h2>{name}</h2>
      </div>
      <div>
        <AiOutlineMenu size={30}></AiOutlineMenu>
        <GoDiffAdded size={30}></GoDiffAdded>
      </div>
    </div>
  );
};

export default ProfileHeader;
