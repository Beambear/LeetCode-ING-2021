package practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1480_RunningSumOfArrayTest {

    @Test
    void runningSum() {
        int[] nums ={1,2,3};
        P1480_RunningSumOfArray test = new P1480_RunningSumOfArray();
        int[] output = test.runningSum(nums);
        int[]   expected = {1,3,6};
        assertArrayEquals(expected,output);
    }
}