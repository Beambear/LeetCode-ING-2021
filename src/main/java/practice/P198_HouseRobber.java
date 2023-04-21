package practice;

public class P198_HouseRobber {

    public int rob(int[] nums){
        if(nums.length ==1){
            return nums[0];
        }
        int[] dp = new int[nums.length+1];
        dp[0]= nums[0];
        dp[1]=nums[1];
        for(int i=0;i<nums.length;i++){
            int next = i+2;
            int next2= i+3;
            if(next<nums.length){
                dp[i+2] = Math.max(dp[i]+nums[i+2],dp[i+2]);
            }
            if(next2<nums.length){
                dp[i+3] = Math.max(dp[i]+nums[i+3],dp[i+3]);
            }
        }
        return Math.max(dp[nums.length-1],dp[nums.length-2]);
    }

    public int robSG(int[] nums) {
        int size = nums.length;
        int[] dp = new int[size];
        if (size == 1) {
            return nums[0];
        } else if (size == 2) {
            return Math.max(nums[0], nums[1]);
        } else if (size == 3) {
            return Math.max(nums[0]+nums[2], nums[1]);
        }
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[2] + nums[0];
        for (int i = 3; i < size; i++) {
            dp[i] = nums[i] + Math.max(dp[i-2], dp[i-3]);
        }
        return Math.max(dp[size-2], dp[size-1]);
    }
}