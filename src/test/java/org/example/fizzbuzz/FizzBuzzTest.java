package org.example.fizzbuzz;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// For learning TDD
public class FizzBuzzTest {
    @Test
    @DisplayName("input 1 should return 1")
    void input1ShouldReturn1() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String actual = fizzBuzz.fizzBuzz(1);

        String expected = "1";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("input 2 should return 2")
    void input2ShouldReturn2() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String actual = fizzBuzz.fizzBuzz(2);

        String expected = "2";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("input 3 should return Fizz")
    void input3ShouldReturnFizz() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String actual = fizzBuzz.fizzBuzz(3);

        String expected = "Fizz";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("input 4 should return 4")
    void input4ShouldReturn4() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String actual = fizzBuzz.fizzBuzz(4);

        String expected = "4";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("input 5 should return Buzz")
    void input5ShouldReturnBuzz() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String actual = fizzBuzz.fizzBuzz(5);

        String expected = "Buzz";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("input 6 should return Fizz")
    void input6ShouldReturnFizz() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String actual = fizzBuzz.fizzBuzz(6);

        String expected = "Fizz";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("input 7 should return 7")
    void input7ShouldReturn7() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String actual = fizzBuzz.fizzBuzz(7);

        String expected = "7";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("input 9 should return Fizz")
    void input9ShouldReturnFizz() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String actual = fizzBuzz.fizzBuzz(9);

        String expected = "Fizz";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("input 15 should return FizzBuzz")
    void input15ShouldReturnFizzBuzz() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String actual = fizzBuzz.fizzBuzz(15);

        String expected = "FizzBuzz";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("input 20 should return Buzz")
    void input20ShouldReturnBuzz() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String actual = fizzBuzz.fizzBuzz(20);

        String expected = "Buzz";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("input 25 should return Buzz")
    void input25ShouldReturnBuzz() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String actual = fizzBuzz.fizzBuzz(25);

        String expected = "Buzz";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("input 30 should return FizzBuzz")
    void input30ShouldReturnFizzBuzz() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String actual = fizzBuzz.fizzBuzz(30);

        String expected = "FizzBuzz";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("input 45 should return FizzBuzz")
    void input45ShouldReturnFizzBuzz() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        String actual = fizzBuzz.fizzBuzz(45);

        String expected = "FizzBuzz";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("input -1 should throw error message")
    void inputNegative1ShouldThrowError() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        assertThrows(IllegalArgumentException.class, () -> fizzBuzz.fizzBuzz(-1));
        try {
            fizzBuzz.fizzBuzz(-1);
            fail("Expected an exception to be thrown.");
        } catch (IllegalArgumentException e) {
            String expected = "Input number must be non-negative";
            assertEquals(expected, e.getMessage());
        }
    }
}
