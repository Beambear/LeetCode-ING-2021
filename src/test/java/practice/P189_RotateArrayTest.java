package practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P189_RotateArrayTest {

    @Test
    void rotate() {
        int[] nums = {1,2,3,4,5, 6,7};
        int k =3;
        int[] expected = {5,6,7,1,2,3,4};
        P189_RotateArray test = new P189_RotateArray();
        assertArrayEquals(expected,test.rotate(nums,k));
    }
}