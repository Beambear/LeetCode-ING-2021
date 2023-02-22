package interview;
/*
字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。

示例1:

 输入："aabcccccaaa"
 输出："a2b1c5a3"
示例2:

 输入："abbccd"
 输出："abbccd"
 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/compress-string-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class I0106_CompressString {
    /////////////////////
    //思路:
    //1.设置两个记录字符串currS和count和结果字符串result.
    //2.遍历字符串：
    // currS与S.charAt(i)匹配-> currS不变，count++
    // currS与S.charAt(i)不匹配 -> result +=currS+count.然后currS变为新的，count=1,
    //3.比较result和S的长度，若一致return S 不然 return result
    //
    //边界考虑： 压缩后的字符串长度至少为2，若S长度<=2直接return S。
    ////////////////////////
    public String compressString(String S) {
        if(S.length()<3){
            return S;
        }
        StringBuilder sb = new StringBuilder(); //StringBuilder 比String+=节约空间
        char curr=S.charAt(0);
        int count=0;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i) == curr){
                count++;
            }else{
                sb.append(curr);
                sb.append(count);
                curr=S.charAt(i);
                count=1;
            }
        }
        sb.append(curr);
        sb.append(count);
        String result = sb.toString();
        if(S.length()>result.length()){
            return result;
        }
        return S;
    }
}
