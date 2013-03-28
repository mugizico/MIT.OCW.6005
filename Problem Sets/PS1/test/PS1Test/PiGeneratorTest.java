package PS1Test;

import PS1.PiGenerator;
import static org.junit.Assert.*;

import org.junit.Test;

public class PiGeneratorTest {

    @Test(expected = RuntimeException.class)
    public void basicPowerModTest() {
        // 5^7 mod 23 = 17
        assertEquals(17, PiGenerator.powerMod(5,  7, 23));  //normal
        assertEquals(-1, PiGenerator.powerMod(-1, 7, 23));  // a  <0
        assertEquals(-1, PiGenerator.powerMod(5, -1, 23));  // b  <0
        assertEquals(-1, PiGenerator.powerMod(5,  1, -2));  // m <0
        assertEquals(-1, PiGenerator.powerMod(-5,-1,-23));  // all <0
        assertEquals(0, PiGenerator.powerMod(Integer.MAX_VALUE,Integer.MAX_VALUE,1));  // ?
        assertEquals(new RuntimeException(), PiGenerator.powerMod(5,  7,  0));  // m = 0 - mod(0)

    }

   @Test
    public void computePiInHexTest() {
       // public static int[] computePiInHex(int precision) {
        assertEquals(null, PiGenerator.computePiInHex(-1));  // precision  < 0
      //  assertEquals(null, PiGenerator.computePiInHex(0));  // precision  = 0
      //  assertEquals(null, PiGenerator.computePiInHex(1));  // precision  = 1
       // assertEquals(null, PiGenerator.computePiInHex(5));  // precision  = 5
      //  assertEquals(null, PiGenerator.computePiInHex(Integer.MAX_VALUE));  // really big number
        
    }
   
      /**
     * Returns precision hexadecimal digits of the fractional part of pi.
     * Returns digits in most significant to least significant order.
     * 
     * If precision < 0, return null.
     * 
     * @param precision The number of digits after the decimal place to
     *                  retrieve.
     * @return precision digits of pi in hexadecimal.
     */
    public static int[] computePiInHex(int precision) {
        // TODO: Implement (Problem 1.d)
        return new int[0];
    }
    
   
   
   
 

}
