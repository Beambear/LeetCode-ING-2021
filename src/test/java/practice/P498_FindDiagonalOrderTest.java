package practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P498_FindDiagonalOrderTest {

    @Test
    void findDiagonalOrderTest1() {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        int[] expected = {1,2,4,7,5,3,6,8,9};
        P498_FindDiagonalOrder test = new P498_FindDiagonalOrder();
        int[] result = test.findDiagonalOrder(mat);
        assertArrayEquals(expected,result);

    }
}