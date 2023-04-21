package practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
You are given a 0-indexed string array words.

Two strings are similar if they consist of the same characters.

For example, "abca" and "cba" are similar since both consist of characters 'a', 'b', and 'c'.
However, "abacba" and "bcfd" are not similar since they do not consist of the same characters.
Return the number of pairs (i, j) such that 0 <= i < j <= word.length - 1 and the two strings words[i] and words[j] are similar.

 

Example 1:

Input: words = ["aba","aabb","abcd","bac","aabc"]
Output: 2
Explanation: There are 2 pairs that satisfy the conditions:
- i = 0 and j = 1 : both words[0] and words[1] only consist of characters 'a' and 'b'.
- i = 3 and j = 4 : both words[3] and words[4] only consist of characters 'a', 'b', and 'c'.
Example 2:

Input: words = ["aabb","ab","ba"]
Output: 3
Explanation: There are 3 pairs that satisfy the conditions:
- i = 0 and j = 1 : both words[0] and words[1] only consist of characters 'a' and 'b'.
- i = 0 and j = 2 : both words[0] and words[2] only consist of characters 'a' and 'b'.
- i = 1 and j = 2 : both words[1] and words[2] only consist of characters 'a' and 'b'.
Example 3:

Input: words = ["nba","cba","dba"]
Output: 0
Explanation: Since there does not exist any pair that satisfies the conditions, we return 0.

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/count-pairs-of-similar-strings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P2506_CountPairsOfSimilarStrings {
    /////
    //思路：
    //  把每个单词sort一遍
    //  正则表达式把 n*a ->a
    //  pairs比较
    ///////////
    public int similarPairs(String[] words){
        Set<String> map = new HashSet<>();
        int count =0;
        for(int i=0;i<words.length;i++){
            char[] temp = words[i].toCharArray();
            Arrays.sort(temp);  //sort
            words[i] = new String(temp);
            words[i] = words[i].replaceAll("(.)\\1*","$1") ;//n*a->a
            if(! map.add(words[i])){
                count++;
            }
        }

        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if(words[i].equals(words[j])){
                    count++;
                }
            }
        }
        return count;
    }
}
