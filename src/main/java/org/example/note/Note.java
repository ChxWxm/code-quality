package org.example.note;

import org.example.text_file.TextFile;

public class Note {
    private final String DEFAULT_FILE_NAME = "note.txt";
    private final TextFile textFile;

    public Note(TextFile textFile) {
        this.textFile = textFile;
        this.create();
    }

    private void create() {
        textFile.createFile(DEFAULT_FILE_NAME);
    }

    public void write(String content) {
        textFile.writeFile(DEFAULT_FILE_NAME, content);
    }

    public String read() {
        return textFile.readFile(DEFAULT_FILE_NAME);
    }
}
