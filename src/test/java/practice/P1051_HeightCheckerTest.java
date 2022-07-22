package practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class P1051_HeightCheckerTest {
    int[] heights = {1,1,4,2,1,3};
    int expected =3;

    @Test
    void heightCheckerVer1() {
        P1051_HeightChecker testV1 =  new P1051_HeightChecker();
        int result = testV1.heightCheckerVer1(heights);
        assertEquals(expected,result);
    }

    @Test
    void heightCheckerVer2() {
        P1051_HeightChecker testV2 =  new P1051_HeightChecker();
        int result = testV2.heightCheckerVer1(heights);
        assertEquals(expected,result);
    }
}