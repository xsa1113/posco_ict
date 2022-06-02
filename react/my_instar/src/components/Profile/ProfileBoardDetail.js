import { Button, Container, Modal } from "reactstrap";
import "./ProfileBoardDetail.css";

const ProfileBoardDetail = ({
  name,
  img,
  isOpen,
  clickPost,
  closeModal,
  onClickDelete,
}) => {
  return (
    <Modal isOpen={isOpen} fullscreen toggle={closeModal}>
      <div className="profileBoardModalHeader">
        <Button close onClick={closeModal}></Button>{" "}
        <div>
          {name}
          <strong>게시물</strong>
        </div>
        <div>
          <Button
            color="danger"
            outline
            onClick={() => onClickDelete(clickPost.id)}
          >
            삭제하기
          </Button>
        </div>
      </div>
      <Container>
        <div className="profileBoardBody">
          <div className="profileBoardBodyHeader">
            <div className="porfileBoardBodyHeaderImgBox">
              <img
                className="profileBoardBodyHeaderImg"
                src={img}
                alt="userImg"
              ></img>
            </div>
            {name}
          </div>
          <img
            className="profileBoardBodyImg"
            src={clickPost?.img}
            alt="postimg"
          ></img>
          <p>{clickPost?.content}</p>
        </div>
      </Container>
    </Modal>
  );
};

export default ProfileBoardDetail;
