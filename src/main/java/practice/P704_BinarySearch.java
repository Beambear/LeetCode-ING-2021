package practice;

public class P704_BinarySearch {
    public int binarySearch(int[] nums, int target)
    {   // not work on leetcode
        int left =0;
        int right =nums.length-1;
        int mid;
        if(target>nums[right] || target<nums[0]){
            return -1;
        }

        while(left<=right) {
            mid = left+(right-left)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return -1;
    }
}
