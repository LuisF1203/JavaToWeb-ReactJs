package org.example.Api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Reader {
    /**
     * Lee y muestra la salida del proceso en el flujo de entrada especificado.
     *
     * @param inputStream el flujo de entrada del proceso.
     * @throws IOException si ocurre un error de entrada o salida.
     */
    static void readProcessOutput(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }

}
