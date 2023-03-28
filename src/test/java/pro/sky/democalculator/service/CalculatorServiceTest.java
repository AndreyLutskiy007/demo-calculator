package pro.sky.democalculator.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pro.sky.democalculator.exception.WrongArgumentException;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = {CalculatorServiceImpl.class})
@ExtendWith(SpringExtension.class)
class CalculatorServiceTest {
    @Autowired
    private CalculatorService calculatorService;

    @Test
    void plus_success() {
        //Подготовка входных данных
        Integer num1 = 2;
        Integer num2 = 3;
        //Подготовка ожидаемого результата
        String answer = "2 + 3 = 5";
        ResponseEntity<String> expectedResult = ResponseEntity.ok(answer);
        //Начало теста
        ResponseEntity<String> absolutResult = calculatorService.plus(num1, num2);
        assertEquals(expectedResult, absolutResult);
    }


    @Test
    void minus_success() {
        //Подготовка входный данных
        Integer num1 = 4;
        Integer num2 = 2;
        //Подготовка ожидаемого результата
        String answer = "4 - 2 = 2";
        ResponseEntity<String> expectedResult = ResponseEntity.ok(answer);
        //Начало теста
        ResponseEntity<String> absolutResult = calculatorService.minus(num1, num2);
        assertEquals(expectedResult, absolutResult);

    }



    @Test
    void multiply_success() {
        //Подготовка входных данных
        Integer num1 = 2;
        Integer num2 = 5;
        //Подготовка ожидаемого результата
        String answer = "2 * 5 = 10";
        ResponseEntity<String> expectedResult = ResponseEntity.ok(answer);
        //Начало теста
        ResponseEntity<String> absolutResult = calculatorService.multiply(num1, num2);
        assertEquals(expectedResult,absolutResult);

    }



    @Test
    void divide_success() {
        //Подготовка входных данных
        Integer num1 = 20;
        Integer num2 = 5;
        //Подготовка ожидаемого результата
        String answer = "20 : 5 = 4.0";
        ResponseEntity<String> expectedResult = ResponseEntity.ok(answer);
        //Начало теста
        ResponseEntity<String> absolutResult = calculatorService.divide(num1, num2);
        assertEquals(expectedResult,absolutResult);
    }



    @Test
    void divide_withWrongArgumentException() {
        //Подготовка входных данных
        Integer num1 = 20;
        Integer num2 = 0;
        //Подготовка ожидаемого результата
        Exception exception = assertThrows(Exception.class, () ->{calculatorService.divide(num1,num2);}
        );
        String expectedMessage = "На 0 делить нельзя";

        //Начало теста
        assertEquals(expectedMessage,exception.getMessage());


    }
}