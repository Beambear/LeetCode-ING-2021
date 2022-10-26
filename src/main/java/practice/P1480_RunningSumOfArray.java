package practice;

public class P1480_RunningSumOfArray {
    public int[] runningSum(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            nums[i+1] = nums[i]+nums[i+1];
        }
        return nums;
    }
}
