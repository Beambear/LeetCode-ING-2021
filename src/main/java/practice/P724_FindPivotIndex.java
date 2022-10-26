package practice;

public class P724_FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int left =0;
        int right=0;
        for(int i=0;i < nums.length;i++)
        {
            right+=nums[i];
        }

        for(int j=0;j<nums.length;j++)
        {
            right -= nums[j];
            if(left == right){
                return j;
            }
            left += nums[j];
        }
        return -1;
    }
}
