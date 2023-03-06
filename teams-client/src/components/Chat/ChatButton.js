import React from 'react';
import ChatIcon from '@mui/icons-material/Chat';

const ChatButton = (props) => {

  return (
    <div className={"chatButton cursorPointer"} onClick={props.toggleChat}>
      <ChatIcon style={{ color: 'white' }} />
    </div>
  );
};

export default ChatButton;
