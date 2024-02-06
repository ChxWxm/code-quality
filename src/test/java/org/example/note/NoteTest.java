package org.example.note;

import io.reactivex.rxjava3.schedulers.Schedulers;
import org.example.birthday.BirthdayChecker;
import org.example.text_file.TextFile;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

        BirthdayChecker birthdayChecker = mock(BirthdayChecker.class);
        when(birthdayChecker.isBirthDay()).thenReturn(false);

        Note note = new Note(textFile, birthdayChecker);

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
        StubBirthdayChecker birthdayChecker = new StubBirthdayChecker();
        Note note = new Note(textFile, birthdayChecker);

        note.write("Reading book");

        assertTrue(textFile.isWriteCalled());
    }

    @Test
    @DisplayName("given today is my birthday write reading book note should contain 🎂")
    void writeReadingBookNoteWithBirthday() {
        MockTextFile textFile = new MockTextFile();
        StubBirthdayChecker birthdayChecker = new StubBirthdayChecker();
        Note note = new Note(textFile, birthdayChecker);

        note.write("Reading book");

        String expected = "Reading book 🎂";
        assertEquals(expected, textFile.getContentWritten());
    }

    @Test
    @DisplayName("given write reading note async should save reading correctly")
    void writeAsyncNote() {
        TextFile textFile = new MockTextFile();
        BirthdayChecker birthdayChecker = new StubBirthdayChecker();
        Note note = new Note(textFile, birthdayChecker);

        note.writeAsync("Reading book", Schedulers.trampoline())
                .test()
                .assertComplete();
    }

    @Test
    @DisplayName("mockito: given today is my birthday write reading book note should contain 🎂")
    void mockitoWriteReadingBookNoteWithBirthday() {
        MockTextFile textFile = new MockTextFile();

        BirthdayChecker birthdayChecker = mock(BirthdayChecker.class);
        when(birthdayChecker.isBirthDay()).thenReturn(true);

        Note note = new Note(textFile, birthdayChecker);

        note.write("Reading book");

        String expected = "Reading book 🎂";
        assertEquals(expected, textFile.getContentWritten());
    }
}

class StubBirthdayChecker extends BirthdayChecker {

    @Override
    public boolean isBirthDay() {
        return true;
    }
}

class MockTextFile extends TextFile {
    private boolean writeCalled;
    private String contentWritten;

    @Override
    public void createFile(String fileName) {
    }

    @Override
    public void writeFile(String fileName, String content) {

        this.writeCalled = true;
        this.contentWritten = content;
    }

    public boolean isWriteCalled() {
        return writeCalled;
    }

    public String getContentWritten() {
        return contentWritten;
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