package practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
给你一个非负整数数组 nums 。在一步操作中，你必须：

选出一个正整数 x ，x 需要小于或等于 nums 中 最小 的 非零 元素。
nums 中的每个正整数都减去 x。
返回使 nums 中所有元素都等于 0 需要的 最少 操作数。

示例 1：

输入：nums = [1,5,0,3,5]
输出：3
解释：
第一步操作：选出 x = 1 ，之后 nums = [0,4,0,2,4] 。
第二步操作：选出 x = 2 ，之后 nums = [0,2,0,0,2] 。
第三步操作：选出 x = 2 ，之后 nums = [0,0,0,0,0] 。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/make-array-zero-by-subtracting-equal-amounts
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P2357_MakeArrayZeroBySubtractingEqualAmounts {
    //////////////////////
    //思路：
    // 找操作步骤次数->排序后数有几个不同数字
    //1.排序， cur =0, step =0
    //2.遍历 nums[i] > cur -> cur = nums[i] & step ++
    //3.return step
    /////////////////////
    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int cur =0;
        int steps=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>cur){
                cur=nums[i];
                steps++;
            }
        }
        return steps;
    }

    /////////////////
    //思路：
    //哈希表
    //所有数添加进哈希表
    //返回哈希表大小
    ////////////////
    public int minimumOperationsB(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }
        return set.size();
    }

}
