package PS1Test;

import PS1.DigitsToStringConverter;
import static org.junit.Assert.*;

import org.junit.Test;

public class DigitsToStringConverterTest {
    @Test
    public void basicNumberSerializerTest() {
        // Input is a 4 digit number, 0.123 represented in base 4
        int[] input = {0, 1, 2, 3};

        // Want to map 0 -> "d", 1 -> "c", 2 -> "b", 3 -> "a"
        char[] alphabet = {'d', 'c', 'b', 'a'};

        String expectedOutput = "dcba";
        assertEquals(expectedOutput,
                     DigitsToStringConverter.convertDigitsToString(
                             input, 4, alphabet));
    }

    
    
     /* If digits[i] >= base or digits[i] < 0 for any i, consider the input
     * invalid, and return null.
     
     * If alphabet.length != base, consider the input invalid, and return null.
     */
    
//    public static String convertDigitsToString(int[] digits, int base, char[] alphabet) {
    
    
    @Test
    public void badInputTest(){
        int[] input = {};
        char[] alphabet = {};
        String expected = "dcba";
        
        assertNull(DigitsToStringConverter.convertDigitsToString(input, 4, alphabet));
        
        
        
    }
     
     
     
    
    
    
    
    
    
    // TODO: Write more tests (Problem 3.a)
}
