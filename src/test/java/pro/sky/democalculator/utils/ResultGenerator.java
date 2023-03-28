package pro.sky.democalculator.utils;

import org.springframework.http.ResponseEntity;

public class ResultGenerator {
    public static ResponseEntity<String> plusGenerator(Integer num1, Integer num2, Integer result) {
        return ResponseEntity.ok(String.format("%s + %s = %s", num1, num2, result));
    }

    public static ResponseEntity<String> minusGenerator(Integer num1, Integer num2, Integer result) {
        return ResponseEntity.ok(String.format("%s - %s = %s", num1, num2, result));
    }

    public static ResponseEntity<String> multipleGenerator(Integer num1, Integer num2, Integer result) {
        return ResponseEntity.ok(String.format("%s * %s = %s", num1, num2, result));
    }

    public static ResponseEntity<String> divideGenerator(Integer num1, Integer num2, double result) {
        return ResponseEntity.ok(String.format("%s : %s = %s", num1, num2, result));
    }
}
