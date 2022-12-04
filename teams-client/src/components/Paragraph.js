import React from "react";
import Typography from '@mui/material/Typography';

function Paragraph(props) {
    return(
        <Typography variant={`h${props.size ? props.size : 5}`} align={`${props.align ? props.align : "center"}`} color={props.color ? props.color : "text.secondary"} paragraph>
        {props.children}
        </Typography>
    );
}
  

  export default Paragraph;