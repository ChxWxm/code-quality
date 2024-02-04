package org.example;

import org.example.note.Note;
import org.example.text_file.TextFile;

// TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TextFile textFile = new TextFile();
        Note note = new Note(textFile);
        note.write("test write file");
        note.write("Java is fun");

        System.out.println("My note:");
        System.out.println(note.read());
    }
}