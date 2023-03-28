package pro.sky.democalculator.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pro.sky.democalculator.utils.ResultGenerator;

import java.util.stream.Stream;

@ContextConfiguration(classes = {CalculatorServiceImpl.class})
@ExtendWith(SpringExtension.class)
public class CalculatorServiceParamTest {
    @Autowired
    public CalculatorService calculatorService;

    public static Stream<Arguments> plusParam() {
        return Stream.of(
                Arguments.of(2, 2, ResultGenerator.plusGenerator(2, 2, 4)),
                Arguments.of(4, 4, ResultGenerator.plusGenerator(4, 4, 8))
        );

    }

    public static Stream<Arguments> minusParam() {
        return Stream.of(
                Arguments.of(10, 5, ResultGenerator.minusGenerator(10, 5, 5)),
                Arguments.of(4, 2, ResultGenerator.minusGenerator(4, 2, 2))
        );
    }

    public static Stream<Arguments> multiplyParam() {
        return Stream.of(
                Arguments.of(3, 3, ResultGenerator.multipleGenerator(3, 3, 9)),
                Arguments.of(2, 2, ResultGenerator.multipleGenerator(2, 2, 4))
        );
    }

    public static Stream<Arguments> divideParam() {
        return Stream.of(
                Arguments.of(5, 5, ResultGenerator.divideGenerator(5, 5, 1.0)),
                Arguments.of(100, 2, ResultGenerator.divideGenerator(100, 2, 50.0)));
    }

    @ParameterizedTest
    @MethodSource("divideParam")
    void divide_success(Integer num1, Integer num2, ResponseEntity<String> expectedResult) {
        Assertions.assertEquals(calculatorService.divide(num1, num2), expectedResult);
    }

    @ParameterizedTest
    @MethodSource("plusParam")
    void plus_success(Integer num1, Integer num2, ResponseEntity<String> expectedResult) {
        Assertions.assertEquals(calculatorService.plus(num1, num2), expectedResult);
    }

    @ParameterizedTest
    @MethodSource("minusParam")
    void minus_success(Integer num1, Integer num2, ResponseEntity<String> expectedResult) {
        Assertions.assertEquals(calculatorService.minus(num1, num2), expectedResult);
    }

    @ParameterizedTest
    @MethodSource("multiplyParam")
    void multiple_success(Integer num1, Integer num2, ResponseEntity<String> exceptedResult) {
        Assertions.assertEquals(calculatorService.multiply(num1, num2), exceptedResult);
    }
}
