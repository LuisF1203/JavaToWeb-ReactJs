import React, { useEffect } from "react";
function Producto3(){
    useEffect(() => {
        document.title = "Producto3";
    }, []);
    return(
        <div id='main-Producto3'>
<div id='container'><div id='product'><img id='productImage' src='https://th.bing.com/th/id/R.d3becdf372885062d43be71559e0580c?rik=JMvmP4gLrV3p3w&riu=http%3a%2f%2fpurepng.com%2fpublic%2fuploads%2flarge%2fpurepng.com-women-dressclothingwomen-dressfashion-women-dress-cloth-apparel-631522326949yy7yw.png&ehk=am%2bm1UhA8vOfEzELOSJ1WxWR10tnymcN6CCb01G3Kkk%3d&risl=&pid=ImgRaw&r=0' alt='productImage'/><div id='productDetails'><p id='productName'>Nombre del Producto: product</p><p id='productPrice'>$99.99</p><p id='productDescription'>Descripción del producto.</p></div></div></div>

        </div>
    );
}

export default Producto3;
