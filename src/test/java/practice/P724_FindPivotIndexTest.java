package practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P724_FindPivotIndexTest {

    @Test
    void pivotIndex() {
        int[] nums = {1,2,3,4,3,2,1};
        int expected = 3;
        P724_FindPivotIndex test = new P724_FindPivotIndex();
        int output = test.pivotIndex(nums);

        assertEquals(expected,output);
    }
}