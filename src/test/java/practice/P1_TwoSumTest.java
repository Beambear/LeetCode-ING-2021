package practice;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P1_TwoSumTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void twoSumTest1() {
        P1_TwoSum test = new P1_TwoSum();
        int[] nums = {1,3,5,9,15,21,34,50,66,99};
        int target = 26;
        int[] expected = {2,5};
        int[] result = test.solution(nums,target);
        assertArrayEquals(expected,result);
    }

    @Test
        void twoSumTest2(){
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] expected = {0,1};
        P1_TwoSum test = new P1_TwoSum();
        assertArrayEquals(expected, test.solution(nums,target));
    }
}