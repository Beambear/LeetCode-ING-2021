package practice;

import java.util.ArrayList;

public class TwoSum {
    public void test(){
        int[] nums= {1, 3, 5, 9, 11, 15, 21, 34, 50, 66, 99};
        int target = 26;
        solution(nums,target);
    }

    private void solution(int[] nums, int target)
    {
        ArrayList<Integer> newNums = new ArrayList<>();
        for(int i=0; i<nums.length;i++)
        {
            if(nums[i] <= target)
            {
                System.out.println(nums[i]);
                newNums.add(nums[i]);
            }
        }
    }
}
