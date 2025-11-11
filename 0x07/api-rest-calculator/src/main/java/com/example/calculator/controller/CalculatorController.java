package com.example.calculator.controller;

import com.example.calculator.model.Calculator;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/calculator")
public class CalculatorController {

    private final Calculator calculator = new Calculator();

    @GetMapping("/welcome")
    public String messageWelcome() {
        return "Bem vindo à CALCULATOR API REST.";
    }

    @GetMapping("/addNumbers")
    public String addNumbers(@RequestParam(name = "number1") Double n1,
                             @RequestParam(name = "number2") Double n2) {
        Double result = calculator.sum(n1, n2);
        return String.valueOf(result);
    }

    @GetMapping("/subNumbers")
    public String subNumbers(@RequestParam(name = "number1") Double n1,
                             @RequestParam(name = "number2") Double n2) {
        Double result = calculator.sub(n1, n2);
        return String.valueOf(result);
    }

    @GetMapping("/divideNumbers")
    public String divideNumbers(@RequestParam(name = "number1") Double n1,
                                @RequestParam(name = "number2") Double n2) {
        Double result = calculator.divide(n1, n2);
        return String.valueOf(result);
    }

    @GetMapping("/factorial")
    public String factorial(@RequestParam(name = "factorial") Integer factorial) {
        Integer result = calculator.factorial(factorial);
        return String.valueOf(result);
    }

    @GetMapping("/calculeDayBetweenDate")
    public String calculeDayBetweenDate(
            @RequestParam("localDate1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate1,
            @RequestParam("localDate2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate2) {

        int result = calculator.calculeDayBetweenDate(localDate1, localDate2);
        return String.valueOf(result);
    }

    @GetMapping("/integerToBinary")
    public String integerToBinary(@RequestParam(name = "number1") Integer n1) {
        Integer result = calculator.integerToBinary(n1);
        return String.valueOf(result);
    }

    @GetMapping("/integerToHexadecimal")
    public String integerToHexadecimal(@RequestParam(name = "number1") Integer n1) {
        String result = calculator.integerToHexadecimal(n1);
        return result;
    }
}
