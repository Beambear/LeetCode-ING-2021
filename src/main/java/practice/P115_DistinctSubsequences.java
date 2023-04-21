package practice;
/*
给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数。

题目数据保证答案符合 32 位带符号整数范围。

 

示例 1：

输入：s = "rabbbit", t = "rabbit"
输出：3
解释：
如下所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
rabbbit
rabbbit
rabbbit
示例 2：

输入：s = "babgbag", t = "bag"
输出：5
解释：
如下所示, 有 5 种可以从 s 中得到 "bag" 的方案。
babgbag
babgbag
babgbag
babgbag
babgbag

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/distinct-subsequences
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P115_DistinctSubsequences {
    /**
     * row column记清
     *
     */
    public int numDistinct(String s, String t){
        int[][] dp = new int[t.length()][s.length()];//创建动态规划表
        int result=0;
        int curCount =0;

        for(int i=0;i<s.length();i++){  //s对应字母表
            if(s.charAt(i) == t.charAt(0)){ //初始化动态规划表
                dp[0][i]=1;
                result+=1;
            }
        }
        if(t.length() <= 1){
            return result;
        }

        //开始动态规划
        for(int i=1;i<dp.length;i++){ //遍历每一行,跳过第0行
            curCount =0;
            result =0;
            for(int j=1;j<dp[0].length;j++){    //遍历每一列的字母
                curCount += dp[i-1][j-1];   //更新count
                if(s.charAt(j) == t.charAt(i)){//如果出现目标字母,。
                    dp[i][j]=curCount;  //记录上一层脚标前面出现的次数
                        result +=curCount;
                    }
            }
        }
        return result;
    }
}
