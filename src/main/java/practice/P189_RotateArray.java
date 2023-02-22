package practice;

import java.util.LinkedList;
import java.util.Queue;

public class P189_RotateArray {
    public int[] rotate(int[] nums, int k) {
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            queue.add(nums[i]);
        }

        for(int j=0;j<nums.length;j++)
        {
            int curr = j+k;
            while(curr>= nums.length)
            {
                curr-=nums.length;
            }
            nums[curr]=queue.remove();
        }
        return nums;
    }
}
