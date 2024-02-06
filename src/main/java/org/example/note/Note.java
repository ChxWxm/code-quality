package org.example.note;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Scheduler;
import org.example.birthday.BirthdayChecker;
import org.example.text_file.TextFile;

public class Note {
    private final String DEFAULT_FILE_NAME = "note.txt";
    private final TextFile textFile;
    private BirthdayChecker birthdayChecker;

    public Note(TextFile textFile) {
        this.textFile = textFile;
        this.create();
    }

    public Note(TextFile textFile, BirthdayChecker birthdayChecker) {
        this.textFile = textFile;
        this.birthdayChecker = birthdayChecker;
        this.create();
    }

    private void create() {
        textFile.createFile(DEFAULT_FILE_NAME);
    }

    public void write(String content) {
        if (birthdayChecker.isBirthDay()) {
            content += " 🎂";
        }
        textFile.writeFile(DEFAULT_FILE_NAME, content);
    }

    // Async Function
    public Completable writeAsync(String content, Scheduler scheduler) {
        return Completable.fromAction(() -> write(content)).subscribeOn(scheduler);
    }

    public String read() {
        return textFile.readFile(DEFAULT_FILE_NAME);
    }
}
