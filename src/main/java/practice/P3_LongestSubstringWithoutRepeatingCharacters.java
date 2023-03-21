package practice;

import java.util.HashSet;
import java.util.Set;

/*
给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 

提示：

0 <= s.length <= 5 * 104
s由英文字母、数字、符号和空格组成

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P3_LongestSubstringWithoutRepeatingCharacters {
    //////////////
    //思路:   哈希表
    //  1.StringBuilder记录字符串//【可删】 不用返回字符串，记录长度即可。
    //  2.用hash表记录是否有重复
    //      出现重复后->比较当前与已记录的最大长度->判断是否要更新最大长度
    ///////////////

    public int lengthOfLongestSubstring(String s){
        if( s.length()<=1 ){
            return s.length();
        }
        int maxLength = 0;
        int curLength = 0;

        for(int i=0;i<s.length()-1;i++){  //遍历字符串
            int j=i;
            Set<Character> cur = new HashSet<>();
            while(j<s.length() && cur.add(s.charAt(j))){//添加非重复
                curLength++;
                j++;
            }
            //出现重复 or 到尽头
            if(curLength > maxLength){
                maxLength = curLength;
            }
            curLength = 0;

        }

        return maxLength;
    }

    /**
     * 思路： 哈希图 - 滑动窗口
     *这里使用了一种常见的解法，即滑动窗口。我们维护一个窗口，保证窗口中的子串不包含重复字符。
     * 窗口的左右端点是start和end，初始值都为0。每次移动右端点，如果发现子串中已经包含了当前字符，则需要移动左端点，
     * 保证窗口中不包含重复字符。
     *
     * 具体而言，我们使用一个HashMap来存储每个字符最后一次出现的位置。如果当前字符已经在HashMap中出现过，
     * 那么我们需要将左端点移到这个字符上一次出现的位置的下一个位置。这样保证了窗口中不包含重复字符。
     *
     * 每次移动右端点的时候，更新窗口的最大长度。最后返回最大长度即可。
     *
     * 下面是代码的详细解释：
     *
     * Copy code
     * public int lengthOfLongestSubstring(String s) {
     *     // 定义一个HashMap，key为字符，value为字符最后一次出现的位置
     *     HashMap<Character, Integer> map = new HashMap<>();
     *     // 定义最大长度和窗口左端点
     *     int max = 0, start = 0;
     *     // 遍历字符串中的每个字符
     *     for (int end = 0; end < s.length(); end++) {
     *         // 获取当前字符
     *         char ch = s.charAt(end);
     *         // 如果当前字符已经在窗口中出现过，需要移动窗口的左端点
     *         if (map.containsKey(ch)){
     *             start = Math.max(map.get(ch)+1,start);
     *         }
     *         // 计算当前窗口的长度，更新最大长度
     *         max = Math.max(max,end - start + 1);
     *         // 将当前字符的位置存入HashMap中
     *         map.put(ch,end);
     *     }
     *     // 返回最大长度
     *     return max;
     * }
     * 该算法的时间复杂度为O(n)，其中n为字符串s的长度。因为每个字符最多只会被遍历两次，一次是右端点移动到该位置，
     * 一次是左端点移动到该位置。而对于空间复杂度，则需要存储每个字符最后一次出现的位置，因此为O(min(n,m))，其中m为字符集的大小。
     */
}
