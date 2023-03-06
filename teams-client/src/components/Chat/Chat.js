import React from "react";
import Register from "@components/Register";
import {isMobile} from 'react-device-detect';

function Chat(props) {
    return(
        <div className="chatContainer">
            <form className={`row-100 padding-2`}>
            <div className="row-100 _row lightgrey">
                         <Register {...props} />
                </div>
            </form>
        </div>
    );
}
  
export default Chat;