package practice;

public class P977_SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] output = new int[nums.length];
        int left=0;
        int right=nums.length-1;
        int i=nums.length-1;
        while(left <= right)
        {
            int leftNum = nums[left]*nums[left];
            int rightNum = nums[right]*nums[right];
            if(leftNum<=rightNum)
            {
                output[i]=rightNum;
                right--;
            }else{
                output[i]=leftNum;
                left++;
            }
            System.out.println(output[i]);
            i--;

        }
        return output;
    }
}
