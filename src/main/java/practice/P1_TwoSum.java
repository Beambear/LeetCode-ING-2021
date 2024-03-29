package practice;

import java.util.ArrayList;

/*
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P1_TwoSum {
    public void test(){
        int[] nums= {1, 3, 5, 9, 11, 15, 21, 34, 50, 66, 99};
        int target = 26;
        solution(nums,target);
    }

    public int[] solution(int[] nums, int target)
    {
        int[] result = new int[2];
        for(int i= nums.length-1; i>0; i--){
            for(int j =0;j<i;j++)
            {
                int sum = nums[i]+nums[j];
                if(sum==target){
                    result[0] = j;
                    result[1] = i;
                    break;
                }
                if(sum>target){
                    continue;
                }
            }
        }
        return result;
    }
}
