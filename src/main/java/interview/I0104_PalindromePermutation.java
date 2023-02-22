package interview;
/*
给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。

审题：
需要确认字符串是否能重排形成回文，而不是当前是否有回文
思路：
1.偶数回文，同样字符出现次数为偶数。
2.奇数回文，只有一个字符出现次数为奇数，其余均为偶数
3.记录每个字符出现次数是否为奇偶
4.奇数结果总出现数<=1则可以重排为回文
 */
public class I0104_PalindromePermutation {
    /*
    首先，我们声明一个长度为 128 的整数数组 charCount，用来存储字符串中每个字符出现的次数。
    然后，我们定义一个变量 countOdd，用来记录字符串中出现次数为奇数的字符数量。
    接下来，我们对字符串进行遍历，统计每个字符出现的次数：
    对于当前遍历到的字符，我们获取其 ASCII 值，并使用它作为 charCount 数组的下标。
    如果当前字符出现的次数是偶数，我们就将 countOdd 变量加 1，表示有一个字符出现次数变为奇数。
    如果当前字符出现的次数是奇数，我们就将 countOdd 变量减 1，表示有一个字符出现次数变为偶数。
    我们将 charCount 数组中当前字符对应的元素加 1，从而记录字符的出现次数。
    最后，我们判断 countOdd 是否小于等于 1，如果是，则说明字符串是一个回文串的排列之一，函数返回 true；否则，函数返回 false。
    */

    public boolean canPermutePalindrome(String s) {
        int[] charCount = new int[128]; //对
        int countOdd = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i);
            if (charCount[val] % 2 == 0) {
                countOdd++;
            } else {
                countOdd--;
            }
            charCount[val]++;
        }
        return countOdd <= 1;
    }
}
