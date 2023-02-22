package interview;

/*
实现一个算法，确定一个字符串 s 的所有字符是否全都不同。

限制：
    0 <= len(s) <= 100
    s[i]仅包含小写字母
    如果你不使用额外的数据结构，会很加分。

思路：
1.考虑字符串范围，是否只包含26个英文字母
2.如果只有26个英文字母，字符串长度大于26即有重复。
3.小于26时验证重复
    a. 两层循环，两两比较（第一反应）
    b.哈希表
    c.位运算(还未理解)
 */



public class I0101_IsUniqueChar {
    /////////////////////
    //a.两层循环，两两比较//
    /////////////////////
    public boolean isUniqueLoop(String astr) {
        if (astr.length() > 26) {   //check length
            return false;
        }
        for (int i = 0; i < astr.length(); i++) {   //first char
            for (int j = i + 1; j < astr.length(); j++) {//second char
                if (astr.charAt(i) == astr.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
