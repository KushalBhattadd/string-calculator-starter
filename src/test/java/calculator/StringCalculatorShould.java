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
    @Test
    void unknown_amount_of_numbers(){
        assertEquals(45,calc.add("1,2,3,4,5,6,7,8,9"));
    }
    @Test
    void handle_new_lines_between_numbers(){
        assertEquals(6,calc.add("1\n2,3"));
    }


}
