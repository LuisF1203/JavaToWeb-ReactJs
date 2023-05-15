package org.example.Api;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Routes {

    /**
     * Crea una nueva ruta con el nombre y la ruta especificados.
     *
     * @param path la ruta de la nueva ruta.
     * @param name el nombre de la nueva ruta.
     * @throws IOException si ocurre un error de entrada o salida.
     */
    public static void createNewRoute(String path, String name) throws IOException {
        ArrayList<String> AppCode = new ArrayList<>();

        System.out.println("creando ruta= '"+name+"' ");
        File App = new File(JavaToWebApi.curretD()+"/"+JavaToWebApi.name+"/src/App.jsx");

        // Leer el contenido del archivo App.jsx
        BufferedReader AppBr= new BufferedReader(new FileReader(App));

        String appSt="";

        // Leer línea por línea del archivo App.jsx
        while ((appSt = AppBr.readLine()) != null){

            AppCode.add(appSt);

            // Agregar el nombre de la ruta a la importación de rutas
            if((appSt).trim().equals("import{")){
                AppCode.add(name+",");
            }   // Agregar la ruta al componente de enrutamiento
            else if((appSt).trim().equals("<Routes>")){
                AppCode.add("<Route path=\""+path+"\" element={<"+name+"/>}/>,");
            }
        }
        StringBuilder AppCodeString=new StringBuilder();
        for (String el:AppCode) {
            AppCodeString.append(el).append("\n");
        }

        // Construir el contenido del nuevo archivo de ruta
        StringBuilder inputRoute = new StringBuilder();
        StringBuilder inputIndexRoute= new StringBuilder();
        inputRoute.append("import React, { useEffect } from \"react\";\n" +
                "function "+name+"(){\n" +
                "    useEffect(() => {\n" +
                "        document.title = \""+name+"\";\n" +
                "    }, []);\n" +
                "    return(\n" +
                "        <div id='main-"+name+"'>\n" +
                "        </div>\n" +
                "    );\n" +
                "}\n" +
                "\n" +
                "export default "+name+";");

        // Leer el contenido del archivo index.js
        File index = new File(JavaToWebApi.curretD()+"/"+JavaToWebApi.name+"/src/views/index.js");
        BufferedReader br= new BufferedReader(new FileReader(index));

        String indexSt;

        // Leer línea por línea del archivo index.js
        while ((indexSt = br.readLine()) != null)
            inputIndexRoute.append(indexSt);

        // Agregar la nueva ruta al archivo index.js
        inputIndexRoute.append("export { default as "+name+" } from \"./"+name+"\";");

        try {
            // Escribir el contenido de la nueva ruta en un archivo
            FileWriter newRoute = new FileWriter(JavaToWebApi.curretD()+"/"+JavaToWebApi.name+"/src/views/"+name+".jsx");
            newRoute.write(String.valueOf(inputRoute));
            newRoute.close();

            // Escribir el contenido modificado en el archivo index.js
            FileWriter newIndexRoute = new FileWriter(JavaToWebApi.curretD()+"/"+JavaToWebApi.name+"/src/views/index.js");
            newIndexRoute.append(String.valueOf(inputIndexRoute));
            newIndexRoute.close();

            // Escribir el contenido modificado en el archivo App.jsx
            FileWriter newCodeApp = new FileWriter(JavaToWebApi.curretD()+"/"+JavaToWebApi.name+"/src/App.jsx");
            newCodeApp.write(String.valueOf(AppCodeString));
            newCodeApp.close();

            System.out.println(name+".jsx creado");
            System.out.println("index.js modificado");
            System.out.println("App.jsx modificado");
        }
        catch (Exception e) {
            e.getStackTrace();
            System.out.println("An error occurred.");
        }
    }






    /**
     * Método para manejar una ruta existente.
     *
     * @param routeName   El nombre de la ruta.
     * @param targetId    El ID del elemento de destino en la ruta.
     * @param element     El elemento a agregar en la ruta.
     * @throws IOException Si ocurre algún error de entrada/salida.
     */
    public static void route(String routeName, String targetId, String element) throws IOException {
        System.out.println("ruta: " + routeName);
        StringBuilder finalRouteCode = new StringBuilder();
        File routeFile = new File(JavaToWebApi.curretD() + "/" + JavaToWebApi.name + "/src/views/" + routeName + ".jsx");
        File indexFile = new File(JavaToWebApi.curretD() + "/" + JavaToWebApi.name + "/src/views/index.js");
        BufferedReader br= new BufferedReader(new FileReader(indexFile));

        String indexSt;

        boolean alreadyRoute=false;
        if (br.readLine().contains(routeName)){
            System.out.println("la ruta: "+routeName+" esta adentro");
            System.out.println(br.readLine());
        }else {
            System.out.println("la ruta: "+routeName+" es nueva");
            System.out.println("creando nueva ruta desde route()");
            Routes.createNewRoute("/" + routeName, routeName);
        }
        br = null;

        try {
            // Leer el contenido del archivo de la ruta existente
            br = new BufferedReader(new FileReader(routeFile));

            boolean found=false;
            while ((indexSt = br.readLine()) != null){
                if(indexSt.trim().contains("id='"+targetId+"-"+routeName+"'")){
                    found=true;
                    if (JavaToWebApi.htmlElements.containsKey(targetId+"-"+routeName)) {
                        // La clave ya existe, obtener la lista actual de elementos y agregar el nuevo elemento
                        List<String> listaActual = JavaToWebApi.htmlElements.get(targetId+"-"+routeName);
                        listaActual.add(element+"\n");
                    } else {
                        // La clave no existe, crear una nueva lista, agregar el elemento y asociarla a la clave
                        List<String> nuevaLista = new ArrayList<>();
                        nuevaLista.add(element+"\n");
                        JavaToWebApi.htmlElements.put(targetId+"-"+routeName, nuevaLista);
                    }
                }
            }
            if (!found) System.err.println("elemento id='"+targetId+"-"+routeName+"' - no encontrado");
            List<String> elementType = JavaToWebApi.htmlElements.get(targetId+"-"+routeName);

            BufferedReader br2= new BufferedReader(new FileReader(routeFile));
            while ((indexSt = br2.readLine()) != null){
                System.out.println(indexSt);
                finalRouteCode.append(indexSt).append("\n");
                if(indexSt.trim().contains("id='"+targetId+"-"+routeName+"'")){
                    for (String e : elementType) {
                        finalRouteCode.append(e).append("\n");
                    }
                }
            }
            try {
                // Escribir el contenido modificado en el archivo de la ruta
                FileWriter newCodeApp = new FileWriter(JavaToWebApi.curretD()+"/"+JavaToWebApi.name+"/src/views/"+routeName+".jsx");
                newCodeApp.write(String.valueOf(finalRouteCode));
                newCodeApp.close();
                System.out.println(routeName+".jsx modificado");
            }
            catch (Exception e) {
                e.getStackTrace();
                System.out.println("An error occurred.");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }

    /**
     * Método para obtener una ruta por su nombre de enlace.
     *
     * @param LinkName       El nombre de enlace de la ruta.
     * @param el             El elemento HTML para la ruta.
     * @param web            Instancia de JavaToWebApi.
     * @param styles         HashMap que contiene los estilos para los elementos.
     * @param javaToWebApi   Instancia de JavaToWebApi.
     * @return               El enlace generado para la ruta.
     * @throws IOException   Si ocurre algún error de entrada/salida.
     */
    public static String getRouteByLink(String LinkName, String el, JavaToWebApi web, HashMap<String, String> styles, JavaToWebApi javaToWebApi) throws IOException {
        Routes.route(LinkName, "main", web.div("container", el));
        StringBuilder finalCss = new StringBuilder();
        for (String id : styles.keySet()) {
            String style = styles.get(id);
            Styles.styles(id, style, javaToWebApi, LinkName);
        }
        return (web.a("productLink", LinkName, el));
    }

}


