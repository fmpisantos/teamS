import { Button, TextField } from "@mui/material";
import React from "react";

function Register(props) {
    const 
    [validEmail, setValidEmail] = React.useState(true),
    [email, setEmail] = React.useState("");

    const validateEmail = (mail=email) => {
        setValidEmail(mail.match(
          /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
        ));
      }

    return(
        <div className="row-90 col-90 margin-top-5 margin-left-5">
            <div className="row-15 col-100 black centerVeritcal padding-5 roundedEdges">
                    <div className="col-93">
                        <h5 className="font-white">Contact us</h5>
                    </div>
                    <div className="col-7">
                        <div className="cursorPointer" onClick={props.toggleChat}>
                            <h5 className="font-white">x</h5>
                        </div>
                    </div>
            </div>
            <div className="row-72 col-100 padding-5 _col">
                <div className="row-10" />
                <TextField variant="standard" size="small" label="Name" className="col-100" />
                <div className="row-10" />
                <TextField value={email} onChange={(e)=>{setEmail(e.target.value)}} error={!validEmail} type="email" variant="standard" size="small" label="Email" className="col-100" />
            </div>
            <div className="row-18 col-100 padding-5 centerHorizontal">
                <Button type="submit" color="info" size="small" variant="outlined" onClick={(e)=>{e.preventDefault();validateEmail();alert("Send message")}}>Send</Button>
            </div>
        </div>
    );
}
  

  export default Register;