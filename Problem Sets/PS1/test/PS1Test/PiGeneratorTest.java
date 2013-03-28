package PS1Test;

import PS1.PiGenerator;
import static org.junit.Assert.*;

import org.junit.Test;

public class PiGeneratorTest {

    @Test(expected = RuntimeException.class)
    public void basicPowerModTest() {
        // 5^7 mod 23 = 17
        assertEquals(17, PiGenerator.powerMod(5, 7, 23));  //normal
        assertEquals(-1, PiGenerator.powerMod(-1, 7, 23));  // a  <0
        assertEquals(-1, PiGenerator.powerMod(5, -1, 23));  // b  <0
        assertEquals(-1, PiGenerator.powerMod(5, 1, -2));  // m <0
        assertEquals(-1, PiGenerator.powerMod(-5, -1, -23));  // all <0
        assertEquals(0, PiGenerator.powerMod(Integer.MAX_VALUE, Integer.MAX_VALUE, 1));  // ?
        assertEquals(new RuntimeException(), PiGenerator.powerMod(5, 7, 0));  // m = 0 - mod(0)

    }

    @Test
    public void computePiInHexTest() {
        // public static int[] computePiInHex(int precision) 
        int[] zero = {};
        int[] one = {3};
        int[] five = {3, 2, 4, 3, 15};

        assertNull(PiGenerator.computePiInHex(-1));  // precision  < 0
        assertArrayEquals(zero, PiGenerator.computePiInHex(0));
        assertArrayEquals(one, PiGenerator.computePiInHex(1));
        assertArrayEquals(five, PiGenerator.computePiInHex(5));
    }
}
