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
        assertEquals(new RuntimeException("Divide by zero"), PiGenerator.powerMod(5,  7,  0));  // m = 0 - mod(0)
     }

  
    
    
 

}
