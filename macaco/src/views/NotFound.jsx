import React, { useEffect } from "react";
function NotFound(){
    useEffect(() => {
        document.title = "NotFound";
    }, []);
    return(
        <div id='main-NotFound'>
<h1 id='title'>LO LAMENTO :(</h1><div id='container'><a id='back' href='/'>regresar</a></div>

        </div>
    );
}

export default NotFound;
