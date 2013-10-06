package PS1Test;

import PS1.WordFinder;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class WordFinderTest {

    @Test
    public void basicGetSubstringsTest() {
        String haystack = "abcde";
        String[] needles = {"ab", "abc", "de", "fg"};

        Map<String, Integer> expectedOutput = new HashMap<String, Integer>();
        expectedOutput.put("ab", 0);
        expectedOutput.put("abc", 0);
        expectedOutput.put("de", 3);

        assertEquals(expectedOutput, WordFinder.getSubstrings(haystack,
                needles));
    }

    @Test
    public void multiMapTest() {
        String haystack = "abcabc";
        String[] needles = {"ab", "abc", "b", "cab", "de"};

        Map<String, Integer> expectedOutput = new HashMap<String, Integer>();
        expectedOutput.put("ab", 0);
        expectedOutput.put("abc", 0);
        expectedOutput.put("b", 1);
        expectedOutput.put("cab", 2);

        assertEquals(expectedOutput, WordFinder.getSubstrings(haystack,
                needles));
    }
}
