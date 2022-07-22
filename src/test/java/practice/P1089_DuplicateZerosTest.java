package practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1089_DuplicateZerosTest {

    @Test
    void duplicateZero() {
        int[] arr = {1,0,2,3,0,4,5,0};
        int[] expected = {1,0,0,2,3,0,0,4};
        P1089_DuplicateZeros test = new P1089_DuplicateZeros();
        test.duplicateZero(arr);
        assertArrayEquals(expected,arr);
    }
}