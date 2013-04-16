package PS1Test;

import PS1.BaseTranslator;
import static org.junit.Assert.*;

import org.junit.Test;

public class BaseTranslatorTest {

    @Test
    public void basicBaseTranslatorTest() {
        // Expect that .01 in base-2 is .25 in base-10
        // (0 * 1/2^1 + 1 * 1/2^2 = .25)
        int[] input = {0, 1};
        int[] expectedOutput = {2, 5};
        assertArrayEquals(expectedOutput,
                BaseTranslator.convertBase(input, 2, 10, 2));
    }

    
    
    @Test
    public void improperInputTests() {
    // convertBase(int[] digits, int baseA, int baseB, int precisionB)
        int[] input = {0, 1};
        int[] badDigits = {0,1,-2,1};
        int[] badBase = {1,1,5,2};

        // If baseA < 2, baseB < 2, or precisionB < 1, return null
        assertNull(BaseTranslator.convertBase(input, 1, 10, 2));
        assertNull(BaseTranslator.convertBase(input, 2, 1, 2));
        assertNull(BaseTranslator.convertBase(input, 2, 2, 0));

        // If digits[i] < 0 or digits[i] >= baseA for any i, return null
        assertNull(BaseTranslator.convertBase(badDigits, 2, 10, 5));
        
        // digits >= base
        assertNull(BaseTranslator.convertBase(badBase, 2, 2, 2));
        assertNull(BaseTranslator.convertBase(badBase, 5, 2, 5));
    }
    
    
}
