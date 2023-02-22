package interview;
/*
URL化。编写一种方法，将字符串中的空格全部替换为%20。
假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。
（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
链接：https://leetcode.cn/problems/string-to-url-lcci

示例 1：
输入："Mr John Smith    ", 13
输出："Mr%20John%20Smith"

示例 2：
输入："               ", 5
输出："%20%20%20%20%20"

思路：
    1.String切为charArray
    2.替换“空格”为%20
    3.CharArray重新写为String
 */
public class I0103_StringToUrl {
    ////
    //超时
    //
    public String replaceSpaces(String s, int length) {
        char[] chars = s.toCharArray(); //String to CharArray
        String s2 ="";  //create a new sting
        for(int i=0;i<length;i++){  //go through charArray
            if(chars[i]==' '){ //replace " "
                s2+="%20";
            }else{
                s2+=chars[i];
            }
        }
        return s2;
    }

    /////////////////
    //双指针
    //1.string to charArray
    //2.前指针在最后一个字符处
    //3.数空格数量，每有一个空格后指针向后退两位// (空格替换为%20， 一个位置边三个位置）
    //4.从后向前，前指针字符放置在后指针处，各指针向前1位
    //5.若遇到空格，后指针放依次放三位0->2->%后前一位
    //6.前后指针重合时便无更多空格
    //7.返回结果
    ////////////
    public String replaceSpacesDoubleIndex(String s, int length) {
    // 边界条件
        if(s == null || s.length() == 0) {
            return s;
        }

        char[] str = s.toCharArray();
        // 双指针位置
        int preIndex = length - 1;
        int lastIndex = preIndex;
        for(int i=0; i < length; i++) {
            if(str[i] == ' ') {
                lastIndex +=2;
            }
        }
        // 替换字符串
        while(lastIndex != preIndex) {
            if(str[preIndex] != ' ') {
                // 复制
                str[lastIndex] = str[preIndex];
                lastIndex--;
                preIndex--;
            } else {
                // 替换 0 2 % ; pre-1; last - 3
                str[lastIndex --] = '0';
                str[lastIndex --] = '2';
                str[lastIndex --] = '%';
                preIndex --;
            }
        }

        return String.valueOf(str).trim();
    }

}
