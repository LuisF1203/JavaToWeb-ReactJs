import React, { useEffect } from "react";
function School(){
    useEffect(() => {
        document.title = "School";
    }, []);
    return(
        <div id='main-School'>
<header id='header'><ul id='headerUl'><li id='homeLink'><a id='homeLinka' href='/'><img id='logo' src='https://th.bing.com/th/id/R.f1014ce37ff053100762dac5f1f49a56?rik=OyFUFRH6DFGUhg&riu=http%3a%2f%2f1000marcas.net%2fwp-content%2fuploads%2f2020%2f03%2flogo-Shein.png&ehk=S0jMXGSNkesC1vjmkUgrg2665yWi0jfR2glew4vdVZ0%3d&risl=&pid=ImgRaw&r=0' alt='logo'/></a></li><input id='searchBar' type='text' placeholder='Buscar'/><li id='shopLink'><a id='shopLink' href='/store'><img id='shopIcon' src='https://cdn3.iconfinder.com/data/icons/city-2-glyph/64/shopping_mall_building_city_town_map_locations-512.png' alt='shopIcon'/></a></li></ul></header><div id='container'><h1 id='title'>Bienvenido a School
</h1><a id='schoolLink' href='https://canvas.iteso.mx'>ir</a><div id='content'><p id='txt'>holaaa</p></div></div>

        </div>
    );
}

export default School;
