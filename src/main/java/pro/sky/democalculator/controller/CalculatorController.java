package pro.sky.democalculator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.democalculator.service.CalculatorService;
import pro.sky.democalculator.service.CalculatorServiceImpl;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/plus")

    public ResponseEntity<String> plus(int num1, int num2) {
        return calculatorService.plus(num1, num2);
    }

    @GetMapping("/minus")
    public ResponseEntity<String> minus(int num1, int num2) {
        return calculatorService.minus(num1, num2);
    }

    @GetMapping("/multiply")
    public ResponseEntity<String> multiply(int num1, int num2) {
        return calculatorService.multiply(num1, num2);
    }

    @GetMapping("/divide")
    public ResponseEntity<String> divide(int num1, int num2) {
        return calculatorService.divide(num1, num2);
    }
}

