package interview;

public class I0105_OneAway {
    /*
    字符串有三种编辑操作:插入一个英文字符、删除一个英文字符或者替换一个英文字符。
    给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。

    示例1:
    输入:
    first = "pale"
    second = "ple"
    输出: True

    示例2:
    输入:
    first = "pales"
    second = "pal"
    输出: False

    来源：力扣（LeetCode）
    链接：https://leetcode.cn/problems/one-away-lcci
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    */

    /////////////////////////////////////
    //思路：
    //1.比较两组字符串长度，相差>1 -> false
    //2.每个数组给一指针，从左到右对比first[n]与second[n]，相似则各指针+1.
    //3.不同则editCount+1.对比first[n+1]与second[n]，相同则表明second缺字.之后对比first[n+1]与second[n]
    //                    对比first[n]与second[n+1].相同则表明second多字，之后对比first[n]与second[n+1]
    //                    对比first[n+1]与second[n+1]，相同则表明second改字，之后对比first[n+1]与second[n+1]
    //4.若不同=出现两次错误->false
    //5.全部检查完若editCount<2 -> true
    ////////////////////////////////////

    public boolean oneEditAwayA(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }
        if (first.length() > second.length()) {
            String temp = first;
            first = second;
            second = temp;
        }
        int i = 0, j = 0, editCount = 0;
        while (i < first.length() && j < second.length()) {
            if (first.charAt(i) == second.charAt(j)) {
                i++;
                j++;
            } else {
                editCount++;
                if (editCount > 1) {
                    return false;
                }
                if (first.length() == second.length()) {
                    i++;
                    j++;
                } else {
                    j++;
                }
            }
        }
        editCount += second.length() - j;
        return editCount <= 1;
    }


    ///////////////////////////
    //思路：
    //符合要求的String长度差只能是0或者1.大于1 ->false
    //于是把长度0和1分开讨论。
    //diff=0，没有缺字，只存在改字，遍历一遍记录不同次数即可。
    //diff=1，一定缺字，若出现改字则false。
    //令s1.length()>s2.length()遍历一遍，当s1[i] != s2[i]时，比较s1[i+1]与s2[i],若还是不同则false
    ////
    public boolean oneEditAwayB(String first, String second){
        if(first.length()==0 && second.length()==0){ //判断临界情况
            return true;
        }
        int diff = first.length() - second.length();
        if(Math.abs(diff)>1){   // >1要改两次，false
            return false;
        }

        int editCount =0;
        if( diff == 0){
            for(int i=0; i<first.length();i++){
                if(first.charAt(i) != second.charAt(i)){
                    editCount++;
                    if(editCount ==2){
                        return false;
                    }
                }
            }
        }else{
            if(diff<0){ // 总让长的作为first，短的second.
                String temp = first;
                first = second;
                second = temp;
            }
            if(first.length()==1 && second.length()==0){
                return true;
            }
            for(int i=first.length()-1;i>0;i--){
                if(first.charAt(i) != second.charAt(i-1+editCount)){  //没有遍历到fisrt[0]
                    System.out.println(first.charAt(i));
                    editCount++;
                    if(editCount >1){
                        return false;
                    }
                }
            }
            if(first.charAt(0)!=second.charAt(0)&&editCount>0){
                return false;
            }
        }
        return true;
    }
}
