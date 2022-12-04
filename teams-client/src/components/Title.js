import React from "react";
import Typography from '@mui/material/Typography';

function Title(props) {
    return(
        <Typography
            component="h1"
            variant={`h${props.size ? props.size : 2}`}
            align="center"
            color="text.primary"
            gutterBottom
          >
            {props.children}
          </Typography>
    );
}
  

  export default Title;