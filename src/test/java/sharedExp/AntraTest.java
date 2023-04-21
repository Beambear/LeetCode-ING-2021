package sharedExp;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AntraTest {

    Antra test = new Antra();


    @Test
    void charMapAndCount() {
        String input = "ABCDCCCDAA";
        Map<Character,Integer> result = test.charMapAndCount(input);
        assertEquals(3, (int) result.get('A'));
        assertEquals(1, (int) result.get('B'));
        assertEquals(4, (int) result.get('C'));
        assertEquals(2, (int) result.get('D'));
    }

    @Test
    void reverseString(){
        char[] input = {'h','e','l','l','o'};
        test.reverseString(input);
        char[] expected = {'o','l','l','e','h'};
        assertArrayEquals(expected,input);
    }

    @Test
    void testFindTwoLargest() {
        int[] input1 = {1, 2, 3, 4, 5};
        Integer[] expected1 = {5, 4};
        assertArrayEquals(expected1, test.findTwoLargest(input1));

        int[] input2 = {5, 4, 3, 2, 1};
        Integer[] expected2 = {5, 4};
        assertArrayEquals(expected2, test.findTwoLargest(input2));

        int[] input3 = {5, 2, 8, 3, 6, 1};
        Integer[] expected3 = {8, 6};
        assertArrayEquals(expected3, test.findTwoLargest(input3));

        int[] input4 = {1};
        Integer[] expected4 ={1,null};
        assertArrayEquals(expected4,test.findTwoLargest(input4));
    }
}