import React, {useState} from 'react'
import { Modal } from "react-bootstrap";

const states = {
  setState: null,
  changeState(data) {
    if (!this.setState) return;
    this.setState((prevData) => {
      return {
        ...prevData,
        ...data
      };
    });
  }
};
  
const handleClose = () => {
  states.changeState({
    open: false
  });
};
  
const ModalPopUp = () => {
  const [data, setData] = useState({
    open: false,
    header: "ini header default",
    message: "ini message default",
    size: "md",
    onClose: handleClose
  });

  states.setState = setData;

  return (
    <Modal show={data.open} onHide={data.onClose} size={data.size}>
      <Modal.Header closeButton>
        <h3 className="modal-title">{data.header}</h3>
      </Modal.Header>
      <Modal.Body>{data.message}</Modal.Body>
    </Modal>
  );
};
  
const openModal = ({ message, header,size, onClose = () => {} }) => {
  states.changeState({
    message,
    header,
    size,
    open: true,
    onClose: () => {
      onClose();
      handleClose();
    }
  });
};

export default ModalPopUp;
export { openModal };