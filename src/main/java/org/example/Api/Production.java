package org.example.Api;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.example.Api.JavaToWebApi.readProcessOutput;

public class Production {
    /**
     * Instala las dependencias npm en el directorio fuente especificado.
     *
     * @param source La ruta del directorio fuente.
     * @throws IOException Sí se produce un error de E/S durante la instalación de paquetes.
     */
    public static void installDep(String source) throws IOException {
        try {
            // Ejecuta el comando "npm i" en el directorio fuente
            Process process = Runtime.getRuntime().exec("cmd /C start /wait npm i", null, new File(source));
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                // Instalación completada con éxito
                System.out.println("La instalación de paquetes npm se ha completado correctamente.");

                // Instala paquetes adicionales react-router-dom y sass
                Process processRouter = Runtime.getRuntime().exec("cmd /C start /wait npm i react-router-dom sass", null, new File(source));
                int exitCodeRouter = processRouter.waitFor();

                if (exitCode == 0) {
                    System.out.println("La instalación de paquetes npm se ha completado correctamente.");
                } else {
                    // Instalación finalizada con un código de salida diferente de cero (indicando un error)
                    System.out.println("La instalación de paquetes npm ha fallado. Código de salida: " + exitCode);
                }
            } else {
                // Instalación finalizada con un código de salida diferente de cero (indicando un error)
                System.out.println("La instalación de paquetes npm ha fallado. Código de salida: " + exitCode);
            }

            // Leer la salida del proceso
            readProcessOutput(process.getInputStream());
            readProcessOutput(process.getErrorStream());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * Método que define una plantilla y genera comentarios.
     */
    public static void defTemp() {
        boolean success = (new File(JavaToWebApi.curretD() + "/" + JavaToWebApi.name + "/src/views")).mkdirs();
        StringBuilder inputIndex = new StringBuilder();
        StringBuilder inputHome = new StringBuilder();
        StringBuilder inputApp = new StringBuilder();
        StringBuilder inputMain = new StringBuilder();
        StringBuilder inputAppCss = new StringBuilder();
        StringBuilder inputIndexCss = new StringBuilder();
        inputAppCss.append("");
        inputIndexCss.append("");
        inputMain.append("import React from 'react'\n" +
                "import ReactDOM from 'react-dom/client'\n" +
                "import App from './App'\n" +
                "import './index.css'\n" +
                "import{BrowserRouter} from 'react-router-dom'\n" +
                "\n" +
                "ReactDOM.createRoot(document.getElementById('root')).render(\n" +
                "  <BrowserRouter>\n" +
                "    <App />\n" +
                "  </BrowserRouter>\n" +
                ")");

        inputApp.append("import { useState } from 'react'\n" +
                "import './App.scss'\n" +
                "import { BrowserRouter, Routes, Route } from \"react-router-dom\";\n" +
                "import{\n" +
                "  Home,\n" +
                "}from \"./views\"\n" +
                "\n" +
                "function App() {\n" +
                "\n" +
                "  return (\n" +
                "    <Routes>\n" +
                "      <Route path=\"/\" element={<Home />} />\n" +
                "    </Routes>\n" +
                "  );\n" +
                "}\n" +
                "\n" +
                "export default App");

        inputIndex.append("export { default as Home } from \"./Home\";");
        inputHome.append("import React, { useEffect } from \"react\";\n" +
                "function Home(){\n" +
                "    return(\n" +
                "        <div id='main-Home'>\n" +
                "        </div>\n" +
                "    )\n" +
                "}\n" +
                "\n" +
                "export default Home");

        try {
            FileWriter index = new FileWriter(JavaToWebApi.curretD() + "/" + JavaToWebApi.name + "/src/views/index.js");
            index.write(String.valueOf(inputIndex));
            index.close();
            FileWriter home = new FileWriter(JavaToWebApi.curretD() + "/" + JavaToWebApi.name + "/src/views/Home.jsx");
            home.write(String.valueOf(inputHome));
            home.close();
            FileWriter app = new FileWriter(JavaToWebApi.curretD() + "/" + JavaToWebApi.name + "/src/App.jsx");
            app.write(String.valueOf(inputApp));
            app.close();
            FileWriter main = new FileWriter(JavaToWebApi.curretD() + "/" + JavaToWebApi.name + "/src/main.jsx");
            main.write(String.valueOf(inputMain));
            main.close();
            FileWriter appCss = new FileWriter(JavaToWebApi.curretD() + "/" + JavaToWebApi.name + "/src/App.scss");
            appCss.write(String.valueOf(inputAppCss));
            appCss.close();
            FileWriter indexCss = new FileWriter(JavaToWebApi.curretD() + "/" + JavaToWebApi.name + "/src/index.css");
            indexCss.write(String.valueOf(inputIndexCss));
            indexCss.close();
            JavaToWebApi.setFinalSourceWeb(JavaToWebApi.curretD() + "/" + JavaToWebApi.name + "/");
            System.out.println("index.js creado");
            System.out.println("Home.jsx creado");
            System.out.println("App.jsx creado");
            System.out.println("Main.jsx creado");
            System.out.println("App.scss creado");
            System.out.println("index.css creado");
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println("An error occurred.");
        }
    }








    /**
     * Crea una aplicación utilizando npm y Vite.
     * @throws IOException si ocurre un error de entrada o salida.
     */
    public static void createApp() throws IOException {
        try {
            Process process = Runtime.getRuntime().exec("cmd /C start /wait npm create vite@latest");
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                // Proceso completado con éxito
                System.out.println("La configuración inicial se ha completado correctamente.");
                try {
                    Thread.sleep(1000);
                    System.out.println(JavaToWebApi.curretD()+"/"+JavaToWebApi.name);
                    Production.installDep(JavaToWebApi.curretD()+"/"+JavaToWebApi.name);
                    defTemp();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                // Proceso finalizado con un código de salida diferente de cero (indicando un error)
                System.out.println("La configuración inicial ha fallado. Código de salida: " + exitCode);
            }

            // Leer la salida del proceso
            readProcessOutput(process.getInputStream());
            readProcessOutput(process.getErrorStream());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }




    /**
     * Ejecuta el comando "npm run dev" para iniciar el modo de desarrollo.
     * @throws IOException si ocurre un error de entrada o salida.
     */
    public static void dev() throws IOException {
        try {
            String workingDirectory = "/"+JavaToWebApi.name; // Ruta a la carpeta deseada
            Process process = Runtime.getRuntime().exec("cmd /C start /wait npm run dev", null, new File(JavaToWebApi.curretD()+"/"+JavaToWebApi.name));
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                // Comando "npm run dev" completado con éxito
                System.out.println("El comando 'npm run dev' se ha completado correctamente.");
            } else {
                // Comando "npm run dev" finalizado con un código de salida diferente de cero (indicando un error)
                System.out.println("El comando 'npm run dev' ha fallado. Código de salida: " + exitCode);
            }

            // Leer la salida del proceso
            readProcessOutput(process.getInputStream());
            readProcessOutput(process.getErrorStream());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


}
