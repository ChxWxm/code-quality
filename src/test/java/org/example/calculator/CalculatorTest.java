package org.example.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
    public Calculator calculator;

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("input 1 and 1 output should be 2")
    void addShouldReturn2() {
        int actual = calculator.add(1, 1);

        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("input 2 and 1 output should be 3")
    void addShouldReturn3() {
        int actual = calculator.add(2, 1);

        int expected = 3;
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1, 0",
            "4, 3, 1"
    })
    @DisplayName("subtract should calculate correctly")
    void subtractShouldReturnCorrectly(int leftOperand, int rightOperand, int expected) {
        int actual = calculator.subtract(leftOperand, rightOperand);

        assertEquals(expected, actual);
    }
}