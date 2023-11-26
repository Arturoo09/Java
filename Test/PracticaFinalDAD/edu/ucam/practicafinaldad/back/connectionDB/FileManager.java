package edu.ucam.practicafinaldad.back.connectionDB;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FileManager {

    private String filePath;
    private List<List<String>> data;

    public FileManager(String filePath) {
        this.filePath = filePath;
        loadData();
    }
    
    public boolean checkCredentials(String username, String password) {
        for (List<String> record : data) {
            if (record.get(1).equals(username) && record.get(2).equals(password)) {
                return true;  // Devuelve 'true' si encuentra una coincidencia
            }
        }
        return false;
    }
    
    public void ensureAdminUserExists() {
        if (!checkCredentials("admin", "admin")) {
            List<String> adminData = new ArrayList<>();
            adminData.add("admin"); // Nombre de usuario
            adminData.add("admin"); // Contraseña
            adminData.add("1"); // Admin flag

            insert(adminData);
            System.out.println("El usuario admin ha sido creado con éxito.");
        } else {
            System.out.println("El usuario admin ya existe.");
        }
    }

    private void loadData() {
        this.data = new ArrayList<>();
        FileConnection connection = FileConnection.getInstance(filePath);
        String line;
        while ((line = connection.readNextLine()) != null) {
            // Suponiendo que la primera línea es el encabezado, puedes omitirla o procesarla de manera diferente
            List<String> values = Arrays.asList(line.split(","));
            data.add(values);
        }
        connection.close();
    }

    public void insert(List<String> newData) {
        data.add(newData);
        writeDataToFile();
    }

    public void update(Predicate<List<String>> filter, List<String> newData) {
        for (List<String> record : data) {
            if (filter.test(record)) {
                record.clear();
                record.addAll(newData);
            }
        }
        writeDataToFile();
    }

    public void delete(Predicate<List<String>> filter) {
        data.removeIf(filter);
        writeDataToFile();
    }

    private void writeDataToFile() {
        try (FileWriter writer = new FileWriter(filePath, false)) {
            for (List<String> record : data) {
                String line = record.stream().collect(Collectors.joining(","));
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
