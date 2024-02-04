package org.example.note;

import org.example.text_file.TextFile;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NoteTest {
    @Test
    @DisplayName("given initial note my note should be empty")
    void initialNoteShouldBeEmpty() {
        MockTextFile textFile = new MockTextFile();
        Note note = new Note(textFile);

        String actual = note.read();

        String expected = "";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("create reading book note should return reading book")
    void createReadingBookNote() {
        StubReadingBookNote textFile = new StubReadingBookNote();
        Note note = new Note(textFile);

        note.write("Reading book");

        String expected = "Reading book";
        assertEquals(expected, note.read());
    }

    @Test
    @DisplayName("my default note file should be note.txt")
    void defaultNoteFile() {
        SpyNoteFile textFile = new SpyNoteFile();
        Note note = new Note(textFile);

        String expected = "note.txt";
        assertEquals(expected, textFile.getSpyFileName());
    }

    @Test
    @DisplayName("initial note should create note.txt only one time")
    void createNoteFileShouldCallOneTime() {
        SpyNoteFile textFile = new SpyNoteFile();
        Note note = new Note(textFile);

        int expected = 1;
        assertEquals(expected, textFile.getSpyCreateCount());
    }

    @Test
    @DisplayName("write reading book note should call write method on TextFile")
    void writeReadingBookNote() {
        MockTextFile textFile = new MockTextFile();
        Note note = new Note(textFile);

        note.write("Reading book");

        assertTrue(textFile.isWriteCalled());
    }
}

class MockTextFile extends TextFile {
    private boolean writeCalled;

    @Override
    public void createFile(String fileName) {
    }

    @Override
    public void writeFile(String fileName, String content) {
        this.writeCalled = true;
    }

    public boolean isWriteCalled() {
        return writeCalled;
    }
}

class StubReadingBookNote extends TextFile {
    @Override
    public String readFile(String fileName) {
        return "Reading book";
    }

    @Override
    public void writeFile(String fileName, String content) {
    }

    @Override
    public void createFile(String fileName) {
    }
}

class SpyNoteFile extends TextFile {
    private String spyFileName;
    private int spyCreateCount = 0;

    @Override
    public void createFile(String fileName) {
        this.spyFileName = fileName;
        this.spyCreateCount++;
    }

    public String getSpyFileName() {
        return spyFileName;
    }

    public int getSpyCreateCount() {
        return spyCreateCount;
    }
}