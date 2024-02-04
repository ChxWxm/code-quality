package org.example.text_file;

import java.io.FileReader;
import java.io.FileWriter;

public class TextFile {
    public void createFile(String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.close();
        } catch (Exception ignored) {
        }
    }

    public void writeFile(String fileName, String content) {
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            fileWriter.write(content);
            fileWriter.close();
        } catch (Exception ignored) {
        }
    }

    public String readFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(fileName);
            int i;
            while ((i = fileReader.read()) != -1) {
                content.append((char) i);
            }
            fileReader.close();
        } catch (Exception ignored) {
        }
        return content.toString();
    }
}
