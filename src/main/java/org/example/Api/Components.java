package org.example.Api;

public class Components {
    /**
     * Genera un elemento de encabezado HTML con un ID y contenido especificados.
     *
     * @param id      El ID del elemento de encabezado.
     * @param content El contenido del elemento de encabezado.
     * @return El elemento de encabezado HTML generado.
     */
    public static String header(String id, String content) {
        return "<header id='" + id + "'>" + content + "</header>";
    }

    /**
     * Genera un elemento de pie de página HTML con un ID y contenido especificados.
     *
     * @param id      El ID del elemento de pie de página.
     * @param content El contenido del elemento de pie de página.
     * @return El elemento de pie de página HTML generado.
     */
    public static String footer(String id, String content) {
        return "<footer id='" + id + "'>" + content + "</footer>";
    }

    /**
     * Genera un nuevo componente personalizado con un ID y contenido especificados.
     *
     * @param id      El ID del nuevo componente.
     * @param content El contenido del nuevo componente.
     * @return El nuevo componente HTML generado.
     */
    public static String newComponent(String id, String content){
        return "<Component-"+id+" id='" + id + "'>" + content + "</Component-"+id+">";
    }

}
