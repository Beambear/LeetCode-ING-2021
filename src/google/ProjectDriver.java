package cs789.project;

public class ProjectDriver {
    public boolean canJump(int[] nums) {
        if(nums.length ==1)
        {
            return true;
        }
        int position = 0;
        return jump(nums,position);
    }

    public boolean jump(int[] nums, int position){
        boolean result = false;
        int maxJump=nums[position];
        for(int i = maxJump;i>0;i--){
            int newPosition = position+i;
            System.out.println("current position"+newPosition+";nums length"+(nums.length-1));
            if(position == nums.length-1){
                System.out.println(position+","+(nums.length-1));
                result = true;
                return  true;
            }else if(newPosition >= nums.length){
                result = false;
            }else{
                result = jump(nums,newPosition);
            }
        }
        System.out.println(result);
        return result;
    }

}
