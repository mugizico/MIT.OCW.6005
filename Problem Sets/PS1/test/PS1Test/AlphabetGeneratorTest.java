package PS1Test;

import PS1.AlphabetGenerator;
import static org.junit.Assert.*;

import org.junit.Test;

public class AlphabetGeneratorTest {
    @Test
    public void generateFrequencyAlphabetTest() {
        // Expect in the training data that Pr(a) = 2/5, Pr(b) = 2/5,
        // Pr(c) = 1/5.
        String[] trainingData = {"aa", "bbc"};
        // In the output for base 10, they should be in the same proportion.
        char[] expectedOutput = {'a', 'a', 'a', 'a',
                                 'b', 'b', 'b', 'b',
                                 'c', 'c'};
        assertArrayEquals(expectedOutput,
                AlphabetGenerator.generateFrequencyAlphabet(
                        10, trainingData));
    }

   /** The letters should occur in lexicographically ascending order in the
     * returned array.
     *   - {"a", "b", "c", "c", "d"} is a valid output.
     *   - {"b", "c", "c", "d", "a"} is not.  
    */
    @Test
    public void badLexOrderTest() {
        String[] trainingData = {"aa", "bbc"};

        char[] expectedOutput = {'a', 'a', 'a', 'a',
                                 'b', 'b', 'b', 'b',
                                 'c', 'c'};
        assertArrayEquals(expectedOutput,
                AlphabetGenerator.generateFrequencyAlphabet(
                        10, trainingData));
    }
    
    
    @Test
    public void badBaseTest() {
        String[] trainingData = {"aa", "bbc"};
        char[] expectedOutput = {'a', 'a', 'a', 'a',
                                 'b', 'b', 'b', 'b',
                                 'c', 'c'};
    
        // if base < 0, return null
        int base = -1;
        assertNull(AlphabetGenerator.generateFrequencyAlphabet(base, trainingData));
 
        //  If base >= 0, the returned array should have length equal to the size of the base.
        base = 10;
        assertEquals(expectedOutput.length,
          AlphabetGenerator.generateFrequencyAlphabet(base, trainingData));
        
     }
    


}
