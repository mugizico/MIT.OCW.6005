package PS1Test;

import PS1.DigitsToStringConverter;
import static org.junit.Assert.*;

import org.junit.Test;

public class DigitsToStringConverterTest {

    @Test
    public void badInputTest() {
        int[] input      = {0, 1, 2, 4};
        int[] inFive     = {0, 1, 2, 4, 5};
        int[] negInput   = {0, 1, -13, 3};
        char[] alphabet = {'d', 'c', 'b', 'a'};
        char[] badAlphabet = {'d', 'c', 'b', 'a', 'q', 'w'};

        // digits[i] >= base    
        assertNull(DigitsToStringConverter.convertDigitsToString(input, 2, alphabet));

        // digits[i] == base
        assertNull(DigitsToStringConverter.convertDigitsToString(input, 3, alphabet));

        // alphabet.lenght != base  (Alphabet.length = 4)   
        assertNull(DigitsToStringConverter.convertDigitsToString(input, 5, alphabet));

        // digits[i] < 0
        assertNull(DigitsToStringConverter.convertDigitsToString(negInput, 4, alphabet));
    
        // digits.length != alphabet.length
        assertNull(DigitsToStringConverter.convertDigitsToString(inFive,5, badAlphabet));
    }

    
    @Test
    public void basicNumberSerializerTest() {
        // Input is a 4 digit number, 0.123 represented in base 4
        int[] input = {0, 1, 2, 3};

        // Want to map 0 -> "d", 1 -> "c", 2 -> "b", 3 -> "a"
        char[] alphabet = {'d', 'c', 'b', 'a'};

        String expectedOutput = "dcba";
        assertEquals(expectedOutput,
                DigitsToStringConverter.convertDigitsToString(input, 4, alphabet));
    }
    
    
    @Test
    public void bigTest() {
        int[] input     = {  0,  1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        String expectedOutput = "abcdefghijklmnopqrstuvwxyz";

        assertEquals(expectedOutput,
                DigitsToStringConverter.convertDigitsToString(input, 26, alphabet));
    }

    
    @Test
    public void reverseTest() {
        int[] input     = { 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10,  9,  8,  7,  6,  5,  4,  3,  2,  1, 0};
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        String expectedOutput = "zyxwvutsrqponmlkjihgfedcba";

        assertEquals(expectedOutput,
                DigitsToStringConverter.convertDigitsToString(input, 26, alphabet));
    }
    
    
    @Test
    public void randomTest() {
        int[] input =     {5, 2, 19, 1, 0, 18, 20, 5, 22, 16, 19, 0, 24, 24};
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n','o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        String expectedOutput = "fctbasufwqtayy";                                

        assertEquals(expectedOutput,
                DigitsToStringConverter.convertDigitsToString(input, 26, alphabet));
    }    
}
