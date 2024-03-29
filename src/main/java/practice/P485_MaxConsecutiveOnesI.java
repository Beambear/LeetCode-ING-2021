package practice;
/*
    给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。

 

示例 1：

输入：nums = [1,1,0,1,1,1]
输出：3
解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
示例 2:

输入：nums = [1,0,1,1,0,1]
输出：2
 

提示：

1 <= nums.length <= 105
nums[i] 不是 0 就是 1.

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/max-consecutive-ones
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P485_MaxConsecutiveOnesI {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max =0;
        int count =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 1){
                count++;
                max = Math.max(max,count);
            }else{
                count = 0;
            }
        }
        return max;
    }
}
