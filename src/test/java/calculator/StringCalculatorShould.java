package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorShould {
    StringCalculator calc;

    @BeforeEach
    void begin(){
        calc = new StringCalculator();
    }

    @Test
    void empty_string_should_return_zero(){
        assertEquals(0, calc.add(""));
    }

    @Test
    void comma_separated_values_should_return_sum(){
        assertEquals(3, calc.add("1,2"));
    }

    
}
