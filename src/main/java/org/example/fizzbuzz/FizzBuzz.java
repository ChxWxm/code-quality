package org.example.fizzbuzz;

public class FizzBuzz {
    public String fizzBuzz(int inputNumber) {
        if (inputNumber < 0) {
            throw new IllegalArgumentException("Input number must be non-negative");
        }

        if (inputNumber % 15 == 0) {
            return "FizzBuzz";
        } else if (inputNumber % 3 == 0) {
            return "Fizz";
        } else if (inputNumber % 5 == 0) {
            return "Buzz";
        }

        return String.valueOf(inputNumber);
    }
}
