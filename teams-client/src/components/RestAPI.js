import React from "react";

function RestAPI() {
    return(
        <div className="row-100 padding-2">
            {/*todo margin top*/}
            <iframe id="swagger" title="swagger" src="SwaggerResources/index.html" width="100%"  height="100%"/>
        </div>
    );
}
  

  export default RestAPI;