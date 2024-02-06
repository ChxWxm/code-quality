package org.example.birthday;

import java.time.LocalDateTime;

public class BirthdayChecker {
    public boolean isBirthDay() {
        LocalDateTime today = LocalDateTime.now();
        // assume birthday is 01 Jan
        return today.getDayOfMonth() == 1 && today.getMonthValue() == 1;
    }
}
