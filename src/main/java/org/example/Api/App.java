package org.example.Api;

import org.example.Api.JavaToWebApi;
import org.example.Api.Routes;

import java.io.IOException;
import java.util.HashMap;

import static org.example.Api.JavaToWebApi.multipleStyles;

public class App {

    public static void main(String[] args) throws IOException {

        JavaToWebApi web = new JavaToWebApi( "macaco");

        web.createApp();
        web.createNewRoute("*", "NotFound");
        web.createNewRoute("/Socials", "Socials");
        web.createNewRoute("/School", "School");

        HashMap<String, String>  mapStylesPerIdTFooter = new HashMap<>();

        // Agregar elementos al HashMap
        mapStylesPerIdTFooter.put("container", "border: 1px solid #e0e0e0; border-radius: 8px; padding: 20px;");


        String headerComponent=web.header("header",
                web.ul("headerUl",
                        web.li("homeLink",
                                web.a("homeLinka","/",web.img("logo","https://th.bing.com/th/id/R.f1014ce37ff053100762dac5f1f49a56?rik=OyFUFRH6DFGUhg&riu=http%3a%2f%2f1000marcas.net%2fwp-content%2fuploads%2f2020%2f03%2flogo-Shein.png&ehk=S0jMXGSNkesC1vjmkUgrg2665yWi0jfR2glew4vdVZ0%3d&risl=&pid=ImgRaw&r=0"
                                        ,"logo")))+
                                web.input("searchBar","text","Buscar")+
                                web.li("shopLink",
                                        web.a("shopLink","/store",web.img("shopIcon","https://cdn3.iconfinder.com/data/icons/city-2-glyph/64/shopping_mall_building_city_town_map_locations-512.png","shopIcon")))
                ));



        String footerComponent = web.footer("footer",
                web.ul("footerUl",
                        web.li("aboutLink",
                                web.getRouteByLink("aboutLink",web.div("container",
                                        web.h1("title","aboutLink")
                                ),web,mapStylesPerIdTFooter)
                        ) +
                                web.li("contactLink",
                                        web.a("contactLink", "/contact", "Contact")) +
                                web.li("privacyLink",
                                        web.a("privacyLink", "/privacy", "Privacy Policy")) +
                                web.li("termsLink",
                                        web.a("termsLink", "/terms", "Terms of Service"))
                )
        );




        web.route("Home", "main",
                headerComponent+
                        web.div("container",
                                web.div("banner",
                                        web.video("bannerVideo", "https://static.bershka.net/4/static/images/home/2023/0505/D_slide_woman_novedades_-1.mp4?20230514020705", "bannerVideo","autoplay='autoplay'","loop","muted") +
                                                web.p("slogan", "Unleash Your Style") +
                                                web.a("shopNow", "/store", "Shop Now")
                                ) +
                                        web.div("featuredProducts",
                                                web.h2("sectionTitle", "Featured Products") +
                                                        web.div("productList",
                                                                web.div("product",
                                                                        web.img("productImage", "https://th.bing.com/th/id/R.d3becdf372885062d43be71559e0580c?rik=JMvmP4gLrV3p3w&riu=http%3a%2f%2fpurepng.com%2fpublic%2fuploads%2flarge%2fpurepng.com-women-dressclothingwomen-dressfashion-women-dress-cloth-apparel-631522326949yy7yw.png&ehk=am%2bm1UhA8vOfEzELOSJ1WxWR10tnymcN6CCb01G3Kkk%3d&risl=&pid=ImgRaw&r=0", "Product 1") +
                                                                                web.h3("productName", "Product 1") +
                                                                                web.p("productDescription", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.")
                                                                ) +
                                                                        web.div("product",
                                                                                web.img("productImage", "https://th.bing.com/th/id/R.d3becdf372885062d43be71559e0580c?rik=JMvmP4gLrV3p3w&riu=http%3a%2f%2fpurepng.com%2fpublic%2fuploads%2flarge%2fpurepng.com-women-dressclothingwomen-dressfashion-women-dress-cloth-apparel-631522326949yy7yw.png&ehk=am%2bm1UhA8vOfEzELOSJ1WxWR10tnymcN6CCb01G3Kkk%3d&risl=&pid=ImgRaw&r=0", "Product 2") +
                                                                                        web.h3("productName", "Product 2") +
                                                                                        web.p("productDescription", "Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.")
                                                                        ) +
                                                                        web.div("product",
                                                                                web.img("productImage", "https://th.bing.com/th/id/R.d3becdf372885062d43be71559e0580c?rik=JMvmP4gLrV3p3w&riu=http%3a%2f%2fpurepng.com%2fpublic%2fuploads%2flarge%2fpurepng.com-women-dressclothingwomen-dressfashion-women-dress-cloth-apparel-631522326949yy7yw.png&ehk=am%2bm1UhA8vOfEzELOSJ1WxWR10tnymcN6CCb01G3Kkk%3d&risl=&pid=ImgRaw&r=0", "Product 3") +
                                                                                        web.h3("productName", "Product 3") +
                                                                                        web.p("productDescription", "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris.")
                                                                        )
                                                        )
                                        ) +
                                        web.div("newsletter",
                                                web.h2("sectionTitle", "Subscribe to Our Newsletter") +
                                                        web.p("newsletterText", "Stay up to date with our latest news and promotions.") +
                                                        web.form("newsletterForm",
                                                                web.input("emailInput", "email", "Email Address") +
                                                                        web.button("subscribeButton", "Subscribe",null)
                                                        )
                                        )
                        ));




        web.route("NotFound", "main",
                web.h1("title", "LO LAMENTO :(") +
                        web.div("container", web.a("back", "/", "regresar"))
        );

        web.route("Socials", "main",
                headerComponent+
                        web.div("container",
                                web.h3("subtitle", "Esta es mi web social") +
                                        web.div("mySocials", web.a("socialIsnsta", "https://instagram.com", "ver insta"))
                        ));

        web.route("School", "main",
                headerComponent+
                        web.div("container",
                                web.h1("title", "Bienvenido a School\n") +
                                        web.a("schoolLink", "https://canvas.iteso.mx", "ir") +
                                        web.div("content", web.p("txt", "holaaa"))
                        ));

        web.route("ChatGPT", "main",
                headerComponent+
                        web.h1("title", "Bienvenido a ChatGPT") +
                        web.div("container", web.a("back", "/", "Regresar"))
        );















        web.createNewRoute("/Store", "Store");



        HashMap<String, String>  mapStylesPerIdT = new HashMap<>();

        // Agregar elementos al HashMap
        mapStylesPerIdT.put("container", "border: 1px solid #e0e0e0; border-radius: 8px; padding: 20px;");
        mapStylesPerIdT.put("product", "display: flex; align-items: center; margin-bottom: 20px;");
        mapStylesPerIdT.put("productImage", "width: 100px; height: 100px; object-fit: cover; margin-right: 10px;");
        mapStylesPerIdT.put("productName", "color: #333333; font-size: 18px; font-weight: bold; margin-bottom: 5px;");
        mapStylesPerIdT.put("productPrice", "color: #ff4500; font-size: 20px; font-weight: bold; margin-bottom: 10px;");
        mapStylesPerIdT.put("productDescription", "color: #666666; font-size: 16px;");


        web.route("Store", "main",
                headerComponent+
                        web.div("container",
                                web.div("content", web.p("txt", "Descubre nuestros productos")) +
                                        web.div("products",
                                                web.h2("subtitle", "Nuestros Productos") +
                                                        web.ul("productList",
                                                                web.li("Producto",
                                                                        web.getRouteByLink("Producto",
                                                                                web.div("product",
                                                                                        web.img("productImage", "https://th.bing.com/th/id/R.d3becdf372885062d43be71559e0580c?rik=JMvmP4gLrV3p3w&riu=http%3a%2f%2fpurepng.com%2fpublic%2fuploads%2flarge%2fpurepng.com-women-dressclothingwomen-dressfashion-women-dress-cloth-apparel-631522326949yy7yw.png&ehk=am%2bm1UhA8vOfEzELOSJ1WxWR10tnymcN6CCb01G3Kkk%3d&risl=&pid=ImgRaw&r=0", "productImage") +
                                                                                                web.div("productDetails",
                                                                                                        web.p("productName", "Nombre del Producto: " + "product") +
                                                                                                                web.p("productPrice", "$99.99") +
                                                                                                                web.p("productDescription", "Descripción del producto.")
                                                                                                )
                                                                                ),web,mapStylesPerIdT)
                                                                ) +
                                                                        web.li("Producto1",
                                                                                web.getRouteByLink("Producto1", web.div("product",
                                                                                        web.img("productImage", "https://th.bing.com/th/id/R.d3becdf372885062d43be71559e0580c?rik=JMvmP4gLrV3p3w&riu=http%3a%2f%2fpurepng.com%2fpublic%2fuploads%2flarge%2fpurepng.com-women-dressclothingwomen-dressfashion-women-dress-cloth-apparel-631522326949yy7yw.png&ehk=am%2bm1UhA8vOfEzELOSJ1WxWR10tnymcN6CCb01G3Kkk%3d&risl=&pid=ImgRaw&r=0", "productImage") +
                                                                                                web.div("productDetails",
                                                                                                        web.p("productName", "Nombre del Producto: " + "product") +
                                                                                                                web.p("productPrice", "$99.99") +
                                                                                                                web.p("productDescription", "Descripción del producto.")
                                                                                                )
                                                                                ),web, mapStylesPerIdT)
                                                                        ) +
                                                                        web.li("Producto2",
                                                                                web.getRouteByLink("Producto2", web.div("product",
                                                                                        web.img("productImage", "https://th.bing.com/th/id/R.d3becdf372885062d43be71559e0580c?rik=JMvmP4gLrV3p3w&riu=http%3a%2f%2fpurepng.com%2fpublic%2fuploads%2flarge%2fpurepng.com-women-dressclothingwomen-dressfashion-women-dress-cloth-apparel-631522326949yy7yw.png&ehk=am%2bm1UhA8vOfEzELOSJ1WxWR10tnymcN6CCb01G3Kkk%3d&risl=&pid=ImgRaw&r=0", "productImage") +
                                                                                                web.div("productDetails",
                                                                                                        web.p("productName", "Nombre del Producto: " + "product") +
                                                                                                                web.p("productPrice", "$99.99") +
                                                                                                                web.p("productDescription", "Descripción del producto.")
                                                                                                )
                                                                                ),web, mapStylesPerIdT)
                                                                        )+
                                                                        web.li("Producto3",
                                                                                web.getRouteByLink("Producto3", web.div("product",
                                                                                        web.img("productImage", "https://th.bing.com/th/id/R.d3becdf372885062d43be71559e0580c?rik=JMvmP4gLrV3p3w&riu=http%3a%2f%2fpurepng.com%2fpublic%2fuploads%2flarge%2fpurepng.com-women-dressclothingwomen-dressfashion-women-dress-cloth-apparel-631522326949yy7yw.png&ehk=am%2bm1UhA8vOfEzELOSJ1WxWR10tnymcN6CCb01G3Kkk%3d&risl=&pid=ImgRaw&r=0", "productImage") +
                                                                                                web.div("productDetails",
                                                                                                        web.p("productName", "Nombre del Producto: " + "product") +
                                                                                                                web.p("productPrice", "$99.99") +
                                                                                                                web.p("productDescription", "Descripción del producto.")
                                                                                                )
                                                                                ),web, mapStylesPerIdT)
                                                                        )
                                                        )
                                        )
                        ));






        //Fot header
        web.styles("container","margin-top:13vh","Home","Socials","Store");





        web.styles("headerUl", "z-index:10;display: flex;justify-content: space-between;position: fixed;left: 0;top: 0;right: 0;margin: 0;background: #ffcfcf;list-style: none;", "Home","Socials","Store");
        web.styles("searchBar","outline: none;border: none;padding-left: 2%;border-radius: 1rem;width: 40%;display: flex;height: 40px;margin: auto;","Home","Socials","Store");
        web.styles("headerUl li a","color: white;text-decoration: none;font-weight: bold;font-size: 2vw;","Home","Socials","Store");
        web.styles("headerUl li", "padding: 1vw;display: flex;margin: auto;", "Home","Socials","Store");
        web.styles("headerUl #homeLink", "width:10%", "Home","Socials","Store");
        web.styles("headerUl #homeLink a img", "width:100%;", "Home","Socials","Store");

        web.styles("headerUl #shopLink", "width:15%;margin:auto", "Home","Socials","Store");
        web.styles("headerUl #shopLink a img", "width:100%", "Home","Socials","Store");

        web.styles("container", "background-color: #f5f5f5;", "Home");
        web.styles("title", "font-size: 32px; color: #333; text-align: center;", "Home");
        web.styles("description", "font-size: 18px; color: #777; margin-bottom: 20px;", "Home");
        web.styles("banner", "text-align: center; margin-bottom: 30px;", "Home");
        web.styles("slogan", "font-size: 24px; font-weight: bold;", "Home");
        web.styles("shopNow", "display: inline-block; background-color: #333; color: #fff; padding: 10px 20px; text-decoration: none; margin-top: 10px;", "Home");
        web.styles("featuredProducts", "margin-bottom: 30px;", "Home");
        web.styles("sectionTitle", "font-size: 24px; color: #333; margin-bottom: 20px;", "Home");
        web.styles("productList", "display: flex; flex-wrap: wrap; justify-content: center;", "Home");
        web.styles("product", "width: 200px; margin: 10px; padding: 10px; background-color: #f9f9f9; text-align: center;", "Home");
        web.styles("productImage", "width: 100px; height: 100px; margin-bottom: 10px;", "Home");
        web.styles("productName", "font-size: 18px; color: #333; font-weight: bold; margin-bottom: 5px;", "Home");
        web.styles("productDescription", "font-size: 14px; color: #777;", "Home");

        web.styles("banner video", "width:100%", "Home");
        web.styles("banner", "width:100vw", "Home");

        web.styles("newsletter", "background-color: #f9f9f9; padding: 20px; margin-top: 30px;", "Home");
        web.styles("newsletterText", "font-size: 18px; color: #333; margin-bottom: 10px;", "Home");
        web.styles("newsletterForm", "display: flex; justify-content: center; align-items: center;", "Home");
        web.styles("emailInput", "width: 200px; padding: 10px; margin-right: 10px;", "Home");
        web.styles("subscribeButton", "background-color: #333; color: #fff; padding: 10px 20px; text-decoration: none;", "Home");










        web.styles( "container", "background:red","Socials");
        web.styles( "title", "color:red;\nbackground:white","NotFound");
        web.styles("container", "color:blue;\nbackground:red","NotFound");






        web.styles("container", "background-color: #f5f5f5; padding: 20px;","Store");
        web.styles( "title", "color: #333333; text-align: center; font-size: 24px; margin-bottom: 20px;","Store");
        web.styles( "storeLink", "display: block; text-align: center; margin-bottom: 20px; color: #0366d6; text-decoration: none; font-weight: bold; font-size: 18px;","Store");
        web.styles("content", "text-align: center; color: #666666; font-size: 16px; margin-bottom: 20px;","Store");
        web.styles( "subtitle", "color: #333333; font-size: 20px; margin-bottom: 10px;","Store");
        web.styles("productList", "list-style-type: none; padding: 0; display: grid; grid-template-columns: repeat(3, 1fr); grid-gap: 20px;","Store");
        web.styles( "product", "border: 1px solid #e0e0e0; padding: 10px;","Store");

        web.styles("product", "border-bottom: 1px solid #e0e0e0; padding: 10px 0;","Store");
        web.styles( "product:last-child", "border-bottom: none;","Store");
        web.styles("productLink", "color: #0366d6; text-decoration: none;","Store");
        web.styles("productImage", "max-width: 100%;","Store");
        web.styles( "productName", "color: #333333; font-size: 16px; margin-bottom: 5px;","Store");
        web.styles("productPrice", "color: #ff4500; font-size: 18px; font-weight: bold;","Store");
        web.styles("productDescription", "color: #666666; font-size: 14px;","Store");

        web.dev();
    }
}