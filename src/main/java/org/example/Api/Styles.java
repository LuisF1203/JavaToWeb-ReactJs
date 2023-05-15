package org.example.Api;

import java.io.*;

public class Styles {
    public static String multipleStyles(String route,String idT,String element) {

        System.out.println("AQUIIIIIIIIIIIIIIIII");
        System.out.println("Generando estilos para multipleStyles: " + idT + "-" + route + "\n" + element);
        System.out.println(stylesPerRoute("main-" + route, "#" + idT + "{\n" + element + ";\n}"));
        System.out.println("AQUIIIIIIIIIIIIIIIII");
        return stylesPerRoute("main-" + route, "#" + idT + "{\n" + element + ";\n}");
    }
    public static String stylesPerRoute(String route, String element){
        return "#"+route+"{\n\t"+element+";\n}";
    }





    public static void styles(String idT, String element, JavaToWebApi javaToWebApi,String... routes) throws IOException {
        idT=idT.trim();
        for (String route : routes) {
            System.out.println("Generando estilos: "+idT+"-"+route+"\n"+element);
            System.out.println(JavaToWebApi.curretD()+"/"+JavaToWebApi.name+"/src/App.scss");
            File routeFile = new File(JavaToWebApi.curretD()+"/"+JavaToWebApi.name+"/src/App.scss");
            BufferedReader br= new BufferedReader(new FileReader(routeFile));
            // Declaring a string variable
            String indexSt;
            // Condition holds true till
            // there is character in a string
            boolean found=false;
            StringBuilder lastCss=new StringBuilder();
            StringBuilder newCss=new StringBuilder();
            while ((indexSt = br.readLine()) != null){
                lastCss.append(indexSt).append("\n");
            }
            newCss.append(stylesPerRoute("main-"+route,"#"+idT+"{\n"+element+";\n}"));
            //newCss.append("#").append(idT).append("{\n\t").append(element).append(";\n}");

            if (lastCss.isEmpty()){
                System.out.println("no hay nada");

                System.out.println(newCss);
                try {
                    FileWriter file = new FileWriter(JavaToWebApi.curretD()+"/"+JavaToWebApi.name+"/src/App.scss");
                    file.write(String.valueOf(newCss));
                    file.close();
                    System.out.println("\t\tCss Updated\n"+javaToWebApi.toString());
                }
                catch (Exception e) {
                    e.getStackTrace();
                    System.out.println("An error occurred.");
                }
            }else {
                System.out.println("pasado: "+lastCss);
                System.out.println("nuevo: "+newCss);
                StringBuilder updatedCss=new StringBuilder();

                boolean tienenMismoContenido = lastCss.toString().trim().equals(newCss.toString().trim());
                if (tienenMismoContenido) {
                    System.out.println("Ningun cambio a realizar.");
                } else {
                    updatedCss.append(lastCss).append("\n").append(newCss);
                    try {
                        FileWriter file = new FileWriter(JavaToWebApi.curretD()+"/"+JavaToWebApi.name+"/src/App.scss");
                        file.write(String.valueOf(updatedCss));
                        file.close();
                        System.out.println("\t\tCss Updated\n"+javaToWebApi.toString());
                    }
                    catch (Exception e) {
                        e.getStackTrace();
                        System.out.println("An error occurred.");
                    }
                }
            }
        }

    }

























}
