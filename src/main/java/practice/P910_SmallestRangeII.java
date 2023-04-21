package practice;

import java.util.Arrays;

/*
给你一个整数数组 nums，和一个整数 k 。

对于每个下标 i（0 <= i < nums.length），将 nums[i] 变成 nums[i] + k 或 nums[i] - k 。

nums 的 分数 是 nums 中最大元素和最小元素的差值。

在更改每个下标对应的值之后，返回 nums 的最小 分数 。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/smallest-range-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P910_SmallestRangeII {
    ///////////////
    //思路：
    //  d= max_0 - min_0
    //  如果2k > d, 最大最小相互靠近后远离，会让最终得分变得更大
    //      所以同+同-能保持当前得分， return (max_0 - min_0)
    //  如果2k < d, 最大最小相互靠近，即使远离也会让差值变小
    //          如此需要寻找新的max_n和min_n。
    //
    //      max_0和min_0在移动[0,d/2]是相互靠近，
    //                  在移动[d/2,d]是相互远离。
    //      那么在最接近 min_0 + d/2的两个数 num[l] 与 num[r]，
    //      相互靠近并远离(+k / -k)后会成为得分最小的min和max组合.
    //
    //      即我们可以遍历, num[i]和num[i+1]。假设他们是最接近min_0+d/2的数。
    //      记录当前得分，并更新当前最大得分。
    //////////////////////////////////////////////////////
    //      另一个方法，直接找到那两个数（不一定对)
    //      那么num[i]<= min_0+d/2时， num[i]+k
    //         num[i]> min_0+d/2时, num[i]-k
    ///////////////////////
    public int smallestRangeII(int[] nums, int k){
        int n = nums.length;
        if(n == 1){
            return 0;
        }
        Arrays.sort(nums);
        int score = nums[nums.length-1] -(nums[0]);  //最初得分

        //遍历相邻的数字,维护最大最小
        for (int i = 0; i < n - 1; i++) {
            int max = Math.max(nums[i] + k, nums[n - 1] - k);
            int min = Math.min(nums[0] + k, nums[i + 1] - k);
            score = Math.min(score, max - min);
        }
        return score;
    }
}
