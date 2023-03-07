package interview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class I0109_StringRotationTest {

    @Test
    void isFlipedString() {
        String s1= "abcd";
        String s2= "acbd";
        I0109_StringRotation Driver = new I0109_StringRotation();
        boolean result = Driver.isFlipedString(s1,s2);
        boolean expected = false;
        assertEquals(expected,result);
    }
}