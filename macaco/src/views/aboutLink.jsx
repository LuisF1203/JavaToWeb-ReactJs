import React, { useEffect } from "react";
function aboutLink(){
    useEffect(() => {
        document.title = "aboutLink";
    }, []);
    return(
        <div id='main-aboutLink'>
<div id='container'><div id='container'><h1 id='title'>aboutLink</h1></div></div>

        </div>
    );
}

export default aboutLink;
