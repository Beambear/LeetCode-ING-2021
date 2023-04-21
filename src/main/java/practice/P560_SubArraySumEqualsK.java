package practice;

import java.util.HashMap;
import java.util.Map;

/*
    给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
 */
public class P560_SubArraySumEqualsK {
    /////////
    //思路：
    //  因为subarry一定是连续的，所以可以用滑动窗口
    //  左指针为subarry左侧，右指针为右侧
    //  右指针for loop向右移动，
    //      如果curSum > targetSum, 左指针向右移动
    //      直到curSum<= targetSum
    //          if curSum == targetSum -> count++
    //  右指针到底后结束 return count
    //////////////
    //  因为会出现负数，滑动窗口不可取。 -1 -1 1, k=0. expected 1, actual 0;
    //             同时当nums[right]>k 时，也不能重置，负数可以让他变小
    /////////////
    //  蜗牛爬行可解决，但是 时间复杂度为n^2,太久
    ////////////
    public int subArraySum(int[] nums, int k){
        int count = 0;
        for(int i =0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                sum+= nums[j];
                if(sum == k){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 前缀和 + 哈希优化
     */
    //////////////
    //思路：需要找到一个子串数字和为k，
    //  我们把子串开头设为num[start],
    //      子串结束设计为num[end],
    //那么 k=∑num[end] - ∑num[start]
    //
    //  例子:
    //      int[] nums = 1 2 3 4 5 6 7, k= 18
    //      ∑num[end]  = 1+2+3+4+5+6+7 = 28
    //      ∑num[start]= 1+2+3+4       = 10
    //->k=∑num[end]-∑num[start]= 5+6+7 = 18.
    //->∑num[end]-k=∑num[start]
    // 即，当我们已知∑num[end] = 28 时候， 只需要找前面 ∑num[i]=10，此时i~end为满足条件的子串
    //
    // 为了减少遍历次数，可以用哈希图来管理 ∑=10的出现次数。
    // 记录为 map<Interger,Interger> = ( ∑ , 出现次数).
    //
    // 当我们找到∑num[end] = 10， findSegema = ∑num[end] - k.
    //  if( map.getVal ( entry ) == findSegema ）{ count++}
    /////////////
    public int subarraySumPrefix(int[] nums, int k){
        HashMap<Integer,Integer> preFixSum = new HashMap<>();
        int sum = 0;
        preFixSum.put(sum,1); //初始值 sum=0，出现1次

        int count = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i]; //当前前缀和
            int target = sum - k;   //目标前缀和

            if (preFixSum.containsKey(target)) {
                count += preFixSum.get(target);
            }


            if(preFixSum.containsKey(sum)){ //更新前缀和哈希图
                int curCount = preFixSum.get(sum)+1;
                preFixSum.put(sum,curCount);
            }else{
                preFixSum.put(sum,1);
            }
        }
        return count;
    }

    /**
     *  **Max Consecutive Ones**
     */
    public int maxConsecutiveOnes(int[] nums){
        int max =0;
        int count =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 1){
                count++;
                max = Math.max(max,count);
            }else{
                count = 0;
            }
        }
        return max;
    }
}