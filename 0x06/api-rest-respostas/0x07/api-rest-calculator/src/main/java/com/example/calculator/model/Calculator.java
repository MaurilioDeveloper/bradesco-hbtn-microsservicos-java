package com.example.calculator.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Calculator {

    public Double sum(Double number1, Double number2) {
        if (number1 == null || number2 == null) {
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        }
        return number1 + number2;
    }

    public Double sub(Double number1, Double number2) {
        if (number1 == null || number2 == null) {
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        }
        return number1 - number2;
    }

    public Double divide(Double number1, Double number2) {
        if (number1 == null || number2 == null) {
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        }
        if (number2 == 0.0) {
            throw new ArithmeticException("Divisão por zero não é permitido.");
        }
        return number1 / number2;
    }

    public Integer factorial(Integer factorial) {
        if (factorial == null) {
            throw new NullPointerException("Número é obrigatório.");
        }
        if (factorial < 0) {
            throw new IllegalArgumentException("Número deve ser não negativo.");
        }
        int result = 1;
        for (int i = 2; i <= factorial; i++) {
            result *= i;
        }
        return result;
    }

    public Integer integerToBinary(Integer integer) {
        if (integer == null) {
            throw new NullPointerException("Número é obrigatório.");
        }
        String binary = Integer.toBinaryString(integer);
        return Integer.parseInt(binary);
    }

    public String integerToHexadecimal(Integer integer) {
        if (integer == null) {
            throw new NullPointerException("Número é obrigatório.");
        }
        return Integer.toHexString(integer).toUpperCase();
    }

    public int calculeDayBetweenDate(LocalDate date1, LocalDate date2) {
        if (date1 == null || date2 == null) {
            throw new NullPointerException("Datas são obrigatórias.");
        }
        long days = ChronoUnit.DAYS.between(date1, date2);
        return (int) days;
    }
}
