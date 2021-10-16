package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorShould {

   StringCalculator c;
   @BeforeEach
    void begin(){
       c = new StringCalculator();
   }
    @Test
    void empty_string_should_return_zero(){
        assertEquals(0,c.add(" "));
    }
}
