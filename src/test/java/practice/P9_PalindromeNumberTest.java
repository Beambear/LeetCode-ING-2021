package practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class P9_PalindromeNumberTest {

    @Test
    void isPalindrome1() {
        int x=12321;
        boolean expected = true;
        P9_PalindromeNumber test = new P9_PalindromeNumber();
        boolean result = test.isPalindrome(x);
        assertEquals(expected,result);
        result = test.isPalindrome2(x);
        assertEquals(expected,result);
    }

    @Test
    void isPalindrome2() {
        int x=-121;
        boolean expected = false;
        P9_PalindromeNumber test = new P9_PalindromeNumber();
        boolean result = test.isPalindrome(x);
        assertEquals(expected,result);
        result = test.isPalindrome2(x);
        assertEquals(expected,result);
    }
}