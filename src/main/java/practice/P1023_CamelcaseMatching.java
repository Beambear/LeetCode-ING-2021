package practice;

import java.util.ArrayList;
import java.util.List;

/*
如果我们可以将小写字母插入模式串 pattern 得到待查询项 query，那么待查询项与给定模式串匹配。（我们可以在任何位置插入每个字符，也可以插入 0 个字符。）

给定待查询列表 queries，和模式串 pattern，返回由布尔值组成的答案列表 answer。只有在待查项 queries[i] 与模式串 pattern 匹配时， answer[i] 才为 true，否则为 false。

 

示例 1：

输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
输出：[true,false,true,true,false]
示例：
"FooBar" 可以这样生成："F" + "oo" + "B" + "ar"。
"FootBall" 可以这样生成："F" + "oot" + "B" + "all".
"FrameBuffer" 可以这样生成："F" + "rame" + "B" + "uffer".
示例 2：

输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
输出：[true,false,true,false,false]
解释：
"FooBar" 可以这样生成："Fo" + "o" + "Ba" + "r".
"FootBall" 可以这样生成："Fo" + "ot" + "Ba" + "ll".
示例 3：

输出：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBaT"
输入：[false,true,false,false,false]
解释：
"FooBarTest" 可以这样生成："Fo" + "o" + "Ba" + "r" + "T" + "est".

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/camelcase-matching
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P1023_CamelcaseMatching {
    /////////
    //思路：
    //  双指针，
    //  pattern 和 queries相等时同时next
    //      否则，只有queries next.
    //          pattern遍历完之前，若出现不匹配大写，return false
    //          pattern遍历完之后，若出现大写， return false
    /////////
    //  边际情况：
    //  queries 和 pattern 不会为空。
    //////////
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();  //建立res
        for(String q:queries){  //遍历每个q
            int p =0;   //pattern 的指针
            boolean flag = true;
            for (int i=0;i<q.length();i++){ //遍历q的每个char
                if(p<pattern.length()-1 && q.charAt(i)==pattern.charAt(p)){ //相同，pattern go next
                    p++;
                    continue;
                }

                if(Character.isUpperCase(q.charAt(i))){
                    flag = false;
                    break;
                }
            }

            if(p<pattern.length()){
                flag = false;
                break;
            }

            if(!flag){
                res.add(false);
            }else{
                res.add(true);
            }
        }
        return res;
    }
}
