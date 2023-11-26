package edu.ucam.practicafinaldad.back.connectionDB;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileConnection {

    private static FileConnection instance = null;
    private BufferedReader reader;

    private FileConnection(String filePath) {
        try {
            this.reader = new BufferedReader(new FileReader(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Error al abrir el archivo CSV", e);
        }
    }

    public static FileConnection getInstance(String filePath) {
        if (instance == null) {
            instance = new FileConnection(filePath);
        }
        return instance;
    }

    public String readNextLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Error al leer del archivo CSV", e);
        }
    }

    public void close() {
        try {
            if (reader != null) {
                reader.close();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al cerrar el archivo CSV", e);
        }
    }
}


