package practice;
/*
Given an array of integers nums, sort the array in ascending order and return it.

You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.

 

Example 1:

Input: nums = [5,2,3,1]
Output: [1,2,3,5]
Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).
Example 2:

Input: nums = [5,1,1,2,0,0]
Output: [0,0,1,1,2,5]
Explanation: Note that the values of nums are not necessairly unique.

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/sort-an-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P912_SortAnArray {
    //////
    //思路：
    //  该题主要是考几个基础排序算法
    //  选择符合条件的空间时间复杂度算法
    //////
    //  按照题意，符合时间复杂度的算法有Merge, Quick, Heap
    //  这里空间复杂度Heap < Merge < Quick
    //            O(1) < O(n) < O（log(n))
    ///////////////////////
    /**
     * 冒泡排序（Bubble Sort）：
     * 时间复杂度：
     * 最好情况：O(n)
     * 平均情况：O(n^2)
     * 最坏情况：O(n^2)
     * 空间复杂度：O(1)
     *
     * 选择排序（Selection Sort）：
     * 时间复杂度：
     * 最好情况：O(n^2)
     * 平均情况：O(n^2)
     * 最坏情况：O(n^2)
     * 空间复杂度：O(1)
     *
     * 插入排序（Insertion Sort）：
     * 时间复杂度：
     * 最好情况：O(n)
     * 平均情况：O(n^2)
     * 最坏情况：O(n^2)
     * 空间复杂度：O(1)
     *
     * 归并排序（Merge Sort）：
     * 时间复杂度：
     * 最好情况：O(nlog(n))
     * 平均情况：O(nlog(n))
     * 最坏情况：O(nlog(n))
     * 空间复杂度：O(n)
     *
     * 快速排序（Quick Sort）：
     * 时间复杂度：
     * 最好情况：O(nlog(n))
     * 平均情况：O(nlog(n))
     * 最坏情况：O(n^2)
     * 空间复杂度：O(log(n))
     *
     * 堆排序（Heap Sort）：
     *时间复杂度：
     * 最好情况：O(nlog(n))
     * 平均情况：O(nlog(n))
     * 最坏情况：O(nlog(n))
     * 空间复杂度：O(1)
     *
     * 计数排序（Counting Sort）：
     * 时间复杂度：
     * 最好情况：O(n + k)
     * 平均情况：O(n + k)
     * 最坏情况：O(n + k)
     * 空间复杂度：O(n + k)
     *
     * 桶排序（Bucket Sort）：
     * 时间复杂度：
     * 最好情况：O(n + k)
     * 平均情况：O(n + k)
     * 最坏情况：O(n^2)
     * 空间复杂度：O(n + k)
     *
     * 基数排序（Radix Sort）：
     * 时间复杂度：
     * 最好情况：O(nk)
     * 平均情况：O(nk)
     * 最坏情况：O(nk)
     * 空间复杂度：O(n + k)
     */
    public int[] sortArray(int[]nums){
        quickSort(nums,0,nums.length-1);
        return nums;
    }
    private void quickSort(int[] nums, int low, int high){
        int p = low++; //定pivot
        while(low<high){    //双指针统一前
            while(nums[low]<=nums[p]){ //low值<p值
                low++;  //不做改变，指针右移
            }
            if(nums[low]>nums[p]){//low值>p值
                swap(nums,low,high);//low值于右侧high值互换位置，
                high--; //high指针左移
            }
        }
        swap(nums,p,--low);//pivot 定位, --low是pivot的index
        quickSort(nums,p,low-1);//左侧
        quickSort(nums,low+1,high);
    }


    private void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left]=nums[right];
        nums[right]=nums[left];
    }
}


class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = nums[(left+right) / 2];
        int sortedIndex = partition(nums, pivot, left, right);
        quickSort(nums, left, sortedIndex-1);
        quickSort(nums, sortedIndex, right);
 }

    public int partition(int[] nums, int pivot, int left, int right) {
        while (left <= right) {
            while (nums[left] < pivot) {
                 left++;
            }
            while (nums[right] > pivot) {
                 right--;
             }
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    public void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
        }
    }