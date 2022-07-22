package practice;
//学校打算为全体学生拍一张年度纪念照。根据要求，学生需要按照 非递减 的高度顺序排成一行。
//
//排序后的高度情况用整数数组 expected 表示，其中 expected[i] 是预计排在这一行中第 i 位的学生的高度（下标从 0 开始）。
//
//给你一个整数数组 heights ，表示 当前学生站位 的高度情况。heights[i] 是这一行中第 i 位学生的高度（下标从 0 开始）。
//
//返回满足 heights[i] != expected[i] 的 下标数量 。
//
//来源：力扣（LeetCode）
//链接：https://leetcode.cn/problems/height-checker
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


import java.util.LinkedList;
import java.util.Queue;

import static java.lang.System.arraycopy;


public class P1051_HeightChecker {


    //////////////////////////////////////
    //insert smallest number into queue
    //remove queue VS heights[i]
    public int heightCheckerVer1(int[] heights){
    Queue<Integer> expected = new LinkedList<>();
    int currnum=0;
    while (expected.size() != heights.length){
        for(int i=0;i<heights.length;i++){
            if(heights[i] == currnum)
            {
                expected.add(heights[i]);
            }
        }
        currnum++;
    }
    int unmatched =0;
    for(int i=0;i<heights.length;i++)
    {
        if(expected.remove() != heights[i]){
            unmatched ++;
        }
    }
    return unmatched;
    }

    //////////////////////////////////////
    // bubble sort
    // check match
    // return unmatched indices
    //
    // PASSED
    public int heightCheckerVer2(int[] heights){
        int[] expected = new int[heights.length];
        arraycopy(heights,0,expected,0,heights.length);
        bubbleSort(expected);
        int unmatched =0;
        for(int i=0; i<heights.length;i++){
            if(heights[i] != expected[i]){
                unmatched += 1;
            }
        }
        return unmatched;
    }

    private int[] bubbleSort(int[] nums){
        int counts = nums.length;
        while(counts != 0 ){
            for(int i=1; i<counts;i++){
                if(nums[i-1]>nums[i]){
                    int curNum = nums[i];
                    nums[i]=nums[i-1];
                    nums[i-1]=curNum;
                }
            }
            counts--;
        }
        return nums;
    }
}
