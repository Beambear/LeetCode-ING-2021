package interview;

import java.util.Arrays;

/*
给定两个由小写字母组成的字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。

思路:
    1.优先验证长度是否一致
    2.1重新排序，是否equal
    2.2计数器列表
 */
public class I0102_CheckPermutation {

    ////////////
    //排序,验证相等.
    //时间 O(nlogn), 排序复杂度O(nlogn),比较O(n),总复杂度O(nlogn+n)=O(nlogn)//
    //空间O(logn),排序O(logn)
    //
    public boolean permutationSort(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();
        Arrays.sort(char1);
        Arrays.sort(char2);
        return Arrays.equals(char1,char2);
    }

    ///////
    //哈希表，记录s1字符次数，s2减去次数。若不为0,则不等
    ////
    public boolean permutationHash(String s1, String s2){
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] table = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            table[s1.charAt(i)]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            table[s2.charAt(i)]--;
            if (table[s2.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }
}
