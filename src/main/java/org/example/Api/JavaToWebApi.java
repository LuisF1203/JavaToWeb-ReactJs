package org.example.Api;

import java.io.*;
import java.util.*;

/**
 * La clase JavaToWebApi permite generar una API web a partir de código Java.
 */
public class JavaToWebApi {

    private String source;
    public static String name;
    private static String finalSourceWeb;
    private List<String> htmlCode;
    /**
     * Un mapa que contiene los elementos HTML generados.
     */
    public  static  Map<String, List<String>> htmlElements = new HashMap<>();
    /**
     * Establece el nombre de la API web.
     *
     * @param name El nombre de la API web.
     */

    public void setName(String name) {
        this.name = name;
    }
    /**
     * Establece la fuente final de la API web.
     *
     * @param finalSourceWeb La fuente final de la API web.
     */

    public static void setFinalSourceWeb(String finalSourceWeb) {
        JavaToWebApi.finalSourceWeb = finalSourceWeb;
    }

    public JavaToWebApi(String name) {
        setName(name);
        this.htmlCode = new ArrayList<>();
    }

    /**
     * Genera un encabezado HTML.
     *
     * @param id      El ID del encabezado.
     * @param content El contenido del encabezado.
     * @return El encabezado HTML generado.
     */
    public String header(String id, String content) {
        return Components.header(id, content);
    }

    /**
     * Genera un pie de página HTML.
     *
     * @param id      El ID del pie de página.
     * @param content El contenido del pie de página.
     * @return El pie de página HTML generado.
     */
    public String footer(String id, String content) {
        return Components.footer(id, content);
    }

    // Tags

    /**
     * Genera una lista desordenada HTML (ul).
     *
     * @param id      El ID de la lista.
     * @param content El contenido de la lista.
     * @return La lista desordenada HTML generada.
     */
    public String ul(String id, String content) {
        return Tags.ul(id, content);
    }

    /**
     * Genera un elemento de lista HTML (li).
     *
     * @param id      El ID del elemento de lista.
     * @param content El contenido del elemento de lista.
     * @return El elemento de lista HTML generado.
     */
    public String li(String id, String content) {
        return Tags.li(id, content);
    }

    /**
     * Genera una etiqueta de imagen HTML (img).
     *
     * @param id      El ID de la imagen.
     * @param blobUrl La URL de la imagen en formato blob.
     * @param alt     El texto alternativo de la imagen.
     * @return La etiqueta de imagen HTML generada.
     */
    public String img(String id, String blobUrl, String alt) {
        return Tags.img(id, blobUrl, alt);
    }

    /**
     * Genera una etiqueta de video HTML (video).
     *
     * @param id         El ID del video.
     * @param sourceUrl  La URL del video.
     * @param alt        El texto alternativo del video.
     * @param more       Opcional: otros atributos del video.
     * @return La etiqueta de video HTML generada.
     */
    public String video(String id, String sourceUrl, String alt, String... more) {
        return Tags.video(id, sourceUrl, alt, more);
    }

    /**
     * Genera una etiqueta de encabezado h1 HTML (h1).
     *
     * @param id      El ID del encabezado.
     * @param element El contenido del encabezado.
     * @return El encabezado h1 HTML generado.
     */
    public String h1(String id, String element) {
        return Tags.h1(id, element);
    }


    /**
     * Genera una etiqueta de encabezado h2 HTML (h2).
     *
     * @param id      El ID del encabezado.
     * @param element El contenido del encabezado.
     * @return El encabezado h2 HTML generado.
     */
    public String h2(String id, String element) {
        return Tags.h2(id, element);
    }

    /**
     * Genera una etiqueta de encabezado h3 HTML (h3).
     *
     * @param id      El ID del encabezado.
     * @param element El contenido del encabezado.
     * @return El encabezado h3 HTML generado.
     */
    public String h3(String id, String element) {
        return Tags.h3(id, element);
    }

    /**
     * Genera una etiqueta de encabezado h4 HTML (h4).
     *
     * @param id      El ID del encabezado.
     * @param element El contenido del encabezado.
     * @return El encabezado h4 HTML generado.
     */
    public String h4(String id, String element) {
        return Tags.h4(id, element);
    }

    /**
     * Genera una etiqueta de encabezado h5 HTML (h5).
     *
     * @param id      El ID del encabezado.
     * @param element El contenido del encabezado.
     * @return El encabezado h5 HTML generado.
     */
    public String h5(String id, String element) {
        return Tags.h5(id, element);
    }

    /**
     * Genera una etiqueta de encabezado h6 HTML (h6).
     *
     * @param id      El ID del encabezado.
     * @param element El contenido del encabezado.
     * @return El encabezado h6 HTML generado.
     */
    public String h6(String id, String element) {
        return Tags.h6(id, element);
    }

    /**
     * Genera una etiqueta de párrafo HTML (p).
     *
     * @param id   El ID del párrafo.
     * @param text El contenido del párrafo.
     * @return El párrafo HTML generado.
     */
    public String p(String id, String text) {
        return Tags.p(id, text);
    }

    /**
     * Genera una etiqueta de div HTML (div).
     *
     * @param id      El ID del div.
     * @param content El contenido del div.
     * @return El div HTML generado.
     */
    public String div(String id, String content) {
        return Tags.div(id, content);
    }

    /**
     * Genera una etiqueta de span HTML (span).
     *
     * @param id   El ID del span.
     * @param text El contenido del span.
     * @return El span HTML generado.
     */
    public String span(String id, String text) {
        return Tags.span(id, text);
    }


    /**
     * Genera una etiqueta de formulario HTML (form).
     *
     * @param id      El ID del formulario.
     * @param content El contenido del formulario.
     * @return El formulario HTML generado.
     */
    public String form(String id, String content) {
        return Tags.form(id, content);
    }

    /**
     * Genera una etiqueta de entrada de texto HTML (input).
     *
     * @param id          El ID de la entrada de texto.
     * @param type        El tipo de entrada de texto.
     * @param placeholder El texto de marcador de posición para la entrada de texto.
     * @return La etiqueta de entrada de texto HTML generada.
     */
    public String input(String id, String type, String placeholder) {
        return Tags.input(id, type, placeholder);
    }

    /**
     * Genera un botón HTML (button).
     *
     * @param id      El ID del botón.
     * @param text    El texto del botón.
     * @param onClick La acción que se ejecuta al hacer clic en el botón.
     * @return El botón HTML generado.
     */
    public String button(String id, String text, String onClick) {
        return Tags.button(id, text, onClick);
    }
    /**
     * Genera un enlace HTML (a).
     *
     * @param id    El ID del enlace.
     * @param href  La URL de destino del enlace.
     * @param text  El texto del enlace.
     * @return El enlace HTML generado.
     */
    public String a(String id, String href, String text) {
        return Tags.a(id, href, text);
    }

    /**
     * Genera estilos CSS múltiples en línea.
     *
     * @param route   La ruta de los estilos CSS.
     * @param idT     El ID del elemento HTML al que se aplican los estilos.
     * @param element El contenido del elemento HTML al que se aplican los estilos.
     * @return La cadena de estilos CSS generada.
     */
    public static String multipleStyles(String route, String idT, String element) {
        return Styles.multipleStyles(route, idT, element);
    }


    /**
     * Aplica estilos a un elemento HTML.
     *
     * @param idT      Identificador del elemento al que se le aplicarán los estilos.
     * @param element  Estilos a aplicar al elemento.
     * @param route    Rutas en las que se utilizará el estilo.
     * @throws IOException Si ocurre un error de E/S.
     */
    public void styles(String idT, String element, String... route) throws IOException {
        Styles.styles(idT, element, this, route);
    }

    /**
     * Obtiene la ruta correspondiente a un enlace.
     *
     * @param LinkName Nombre del enlace.
     * @param el       Elemento HTML del enlace.
     * @param web      Instancia de JavaToWebApi.
     * @param styles   Estilos a aplicar al enlace.
     * @return La ruta generada para el enlace.
     * @throws IOException Si ocurre un error de E/S.
     */
    public String getRouteByLink(String LinkName, String el, JavaToWebApi web, HashMap<String, String> styles) throws IOException {
        return Routes.getRouteByLink(LinkName, el, web, styles, this);
    }

    /**
     * Inicia el entorno de desarrollo.
     *
     * @throws IOException Si ocurre un error de E/S.
     */
    public void dev() throws IOException {
        Production.dev();
    }

    /**
     * Retorna el directorio actual del usuario.
     *
     * @return El directorio actual del usuario.
     */
    public static String curretD() {
        String dir = System.getProperty("user.dir");
        return dir;
    }

    /**
     * Crea una nueva ruta.
     *
     * @param path Ruta de la nueva ruta.
     * @param name Nombre de la nueva ruta.
     * @throws IOException Si ocurre un error de E/S.
     */
    public void createNewRoute(String path, String name) throws IOException {
        Routes.createNewRoute(path, name);
    }

    /**
     * Crea una nueva aplicación.
     *
     * @throws IOException Si ocurre un error de E/S.
     */
    public void createApp() throws IOException {
        Production.createApp();
    }

    /**
     * Define una plantilla por defecto.
     */
    public void defTemp() {
        Production.defTemp();
    }

    /**
     * Lee la salida del proceso proporcionado.
     *
     * @param inputStream Flujo de entrada del proceso.
     * @throws IOException Si ocurre un error de E/S.
     */
    static void readProcessOutput(InputStream inputStream) throws IOException {
        Reader.readProcessOutput(inputStream);
    }



    @Override
    public String toString() {
        return "Web Info\n------------------------------\nName: "+name+"\nSource: "+source+"/"+name+".html"+"\n------------------------------\n";
    }

}