package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorShould {
    StringCalculator calc;
    int count =0;

    @BeforeEach
    void begin(){
        calc = new StringCalculator();
        count++;
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
    @Test
    void Support_different_delimiters(){
        assertEquals(3,calc.add("//;\n1;2"));
    }
    @Test
    void Calling_Add_with_a_negative_number_will_throw_an_exception(){
        assertThrows(IllegalArgumentException.class, ()->{
            calc.add("1,-2");
        }, "negatives not allowed -2");
    }
    @Test
    void Calling_Add_with_a_Mutiple_negative_number_will_throw_an_exception() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.add("1,-2,-3");
        }, "negatives not allowed -2 -3");
    }
    @Test
    void GetCallCount_should_return_number_of_Count(){
        assertEquals(count-1, calc.GetCalledCount());
    }
    @Test
    void Numbers_bigger_than_1000_should_be_ignored(){
        assertEquals(2,calc.add("1002,2"));
    }
    @Test
    void Delimiters_can_be_of_any_length(){
        assertEquals(6,calc.add("//[***]\n1***2***3"));
    }
    @Test
    void Allow_multiple_delimiters(){
        assertEquals(6,calc.add("//[*][%]\n1*2%3"));
    }
    @Test
    void   handle_multiple_delimiters_with_length_longer_than_one_char(){
        assertEquals(6,calc.add("//[**][%%]\n1**2%%3"));
    }
}
