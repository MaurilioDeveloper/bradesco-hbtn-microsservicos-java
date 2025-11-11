package com.example.calculator.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    void sumTest() {
        Calculator calculator = new Calculator();
        Double result = calculator.sum(10.0, 5.0);
        assertEquals(15.0, result);
    }

    @Test
    public void numbersNullSumTest() {
        Calculator calculator = new Calculator();
        NullPointerException ex = assertThrows(
                NullPointerException.class,
                () -> calculator.sum(null, 5.0)
        );
        assertEquals("Número 1 e número 2 são obrigatórios.", ex.getMessage());
    }

    @Test
    void subTest() {
        Calculator calculator = new Calculator();
        Double result = calculator.sub(10.0, 4.0);
        assertEquals(6.0, result);
    }

    @Test
    void divideTest() {
        Calculator calculator = new Calculator();
        Double result = calculator.divide(10.0, 2.0);
        assertEquals(5.0, result);
    }

    @Test
    public void divisionByZeroTest() {
        Calculator calculator = new Calculator();
        ArithmeticException ex = assertThrows(
                ArithmeticException.class,
                () -> calculator.divide(10.0, 0.0)
        );
        assertEquals("Divisão por zero não é permitido.", ex.getMessage());
    }

    @Test
    void factorialTest() {
        Calculator calculator = new Calculator();
        Integer result = calculator.factorial(5);
        assertEquals(120, result);
    }

    @Test
    void integerToBinaryTest() {
        Calculator calculator = new Calculator();
        Integer result = calculator.integerToBinary(5);
        assertEquals(101, result);
    }

    @Test
    void integerToHexadecimalTest() {
        Calculator calculator = new Calculator();
        String result = calculator.integerToHexadecimal(170);
        assertEquals("AA", result);
    }

    @Test
    void calculeDayBetweenDateTest() {
        Calculator calculator = new Calculator();
        LocalDate d1 = LocalDate.of(2020, 3, 15);
        LocalDate d2 = LocalDate.of(2020, 3, 29);
        int result = calculator.calculeDayBetweenDate(d1, d2);
        assertEquals(14, result);
    }
}
