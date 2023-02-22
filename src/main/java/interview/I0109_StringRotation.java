package interview;

import java.lang.reflect.Array;
import java.util.ArrayList;

/*
字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。

示例1:
 输入：s1 = "waterbottle", s2 = "erbottlewat"
 输出：True

示例2:
 输入：s1 = "aa", s2 = "aba"
 输出：False

提示：
字符串长度在[0, 100000]范围内。
说明:
你能只调用一次检查子串的方法吗？

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/string-rotation-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class I0109_StringRotation {
    ////////
    //思路：
    //1.判断s1和s2的长度是否一样。 不一样->false
    //2.记录s1首字母c1在s2中出现的坐标，记录为数字数组positions int []
    //3.从position[0] to [p]
        //遍历[n]个数，对比s1[i] ?= s2[i+p]. n= s1.length（）， when i+p>n ->p=-i
        //遇不同则break。完成遍历->true
    public boolean isFlipedString(String s1, String s2){
        if(s1.length()!=s2.length()){   //1.判断等长
            return false;
        }

        if(s1.length()==s2.length()&&s1.length()==0){
            return true;
        }

        int n = s1.length();
        Character c0 = s1.charAt(0);
        ArrayList<Integer> positions = new ArrayList<Integer>();
        for(int i=0;i<n;i++){   //2.记录坐标
            if(s2.charAt(i) == (c0)){
                positions.add(i);
            }
        }

        //3.遍历对比
        for(int i=0;i< positions.size();i++){
            int count =0;
            int curPosition= positions.get(i);

            while(count < n){

                if(curPosition+count==n){
                    curPosition= -count;
                }
                if(s1.charAt(count)!=s2.charAt(curPosition+count)){
                    continue;
                }
                count++;
                if(count ==n){
                    return true;    //顺利完成遍历 ->true
                }
            }
        }
        return false;
    }
}
