import React, { useEffect } from "react";
function Home(){
    return(
        <div id='main-Home'>
<header id='header'><ul id='headerUl'><li id='homeLink'><a id='homeLinka' href='/'><img id='logo' src='https://th.bing.com/th/id/R.f1014ce37ff053100762dac5f1f49a56?rik=OyFUFRH6DFGUhg&riu=http%3a%2f%2f1000marcas.net%2fwp-content%2fuploads%2f2020%2f03%2flogo-Shein.png&ehk=S0jMXGSNkesC1vjmkUgrg2665yWi0jfR2glew4vdVZ0%3d&risl=&pid=ImgRaw&r=0' alt='logo'/></a></li><input id='searchBar' type='text' placeholder='Buscar'/><li id='shopLink'><a id='shopLink' href='/store'><img id='shopIcon' src='https://cdn3.iconfinder.com/data/icons/city-2-glyph/64/shopping_mall_building_city_town_map_locations-512.png' alt='shopIcon'/></a></li></ul></header><div id='container'><div id='banner'><video id='bannerVideo' src='https://static.bershka.net/4/static/images/home/2023/0505/D_slide_woman_novedades_-1.mp4?20230514020705' alt='bannerVideo' autoplay='autoplay' loop muted  ></video><p id='slogan'>Unleash Your Style</p><a id='shopNow' href='/store'>Shop Now</a></div><div id='featuredProducts'><h2 id='sectionTitle'>Featured Products</h2><div id='productList'><div id='product'><img id='productImage' src='https://th.bing.com/th/id/R.d3becdf372885062d43be71559e0580c?rik=JMvmP4gLrV3p3w&riu=http%3a%2f%2fpurepng.com%2fpublic%2fuploads%2flarge%2fpurepng.com-women-dressclothingwomen-dressfashion-women-dress-cloth-apparel-631522326949yy7yw.png&ehk=am%2bm1UhA8vOfEzELOSJ1WxWR10tnymcN6CCb01G3Kkk%3d&risl=&pid=ImgRaw&r=0' alt='Product 1'/><h3 id='productName'>Product 1</h3><p id='productDescription'>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p></div><div id='product'><img id='productImage' src='https://th.bing.com/th/id/R.d3becdf372885062d43be71559e0580c?rik=JMvmP4gLrV3p3w&riu=http%3a%2f%2fpurepng.com%2fpublic%2fuploads%2flarge%2fpurepng.com-women-dressclothingwomen-dressfashion-women-dress-cloth-apparel-631522326949yy7yw.png&ehk=am%2bm1UhA8vOfEzELOSJ1WxWR10tnymcN6CCb01G3Kkk%3d&risl=&pid=ImgRaw&r=0' alt='Product 2'/><h3 id='productName'>Product 2</h3><p id='productDescription'>Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p></div><div id='product'><img id='productImage' src='https://th.bing.com/th/id/R.d3becdf372885062d43be71559e0580c?rik=JMvmP4gLrV3p3w&riu=http%3a%2f%2fpurepng.com%2fpublic%2fuploads%2flarge%2fpurepng.com-women-dressclothingwomen-dressfashion-women-dress-cloth-apparel-631522326949yy7yw.png&ehk=am%2bm1UhA8vOfEzELOSJ1WxWR10tnymcN6CCb01G3Kkk%3d&risl=&pid=ImgRaw&r=0' alt='Product 3'/><h3 id='productName'>Product 3</h3><p id='productDescription'>Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris.</p></div></div></div><div id='newsletter'><h2 id='sectionTitle'>Subscribe to Our Newsletter</h2><p id='newsletterText'>Stay up to date with our latest news and promotions.</p><form id='newsletterForm'><input id='emailInput' type='email' placeholder='Email Address'/><button id='subscribeButton' onClick={() => null}>Subscribe</button></form></div></div>

        </div>
    )
}

export default Home