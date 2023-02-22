package practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P977_SquaresOfASortedArrayTest {

    @Test
    void sortedSquares() {
        int[] nums= {-4,-1,0,3,10};
        int[] expected={0,1,9,16,100};
        P977_SquaresOfASortedArray test = new P977_SquaresOfASortedArray();
        assertArrayEquals(expected,test.sortedSquares(nums));
    }
}