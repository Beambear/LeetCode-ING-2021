package practice;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P704_BinarySearchTest {

    @Test
    void test1(){
        int[] nums={-1,0,3,5,9,12};
        int target =9;
        int expected =4;
        P704_BinarySearch newTest = new P704_BinarySearch();
        int result=newTest.binarySearch(nums,target);
        assertEquals(expected,result);
    }
}