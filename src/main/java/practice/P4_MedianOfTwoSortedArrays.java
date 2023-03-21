package practice;
/*
给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。

算法的时间复杂度应该为 O(log (m+n)) 。

 

示例 1：

输入：nums1 = [1,3], nums2 = [2]
输出：2.00000
解释：合并数组 = [1,2,3] ，中位数 2
示例 2：

输入：nums1 = [1,2], nums2 = [3,4]
输出：2.50000
解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/median-of-two-sorted-arrays
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P4_MedianOfTwoSortedArrays {

    ////////////////
    //思路:
    //  0.查看是否有空数组
    //  1.计算两条数组的总长度
    //      长度为偶数则两个数的平均值是中位数
    //      长度为奇数则中间的数为中位数
    //  2.双指针i和j， 比较num1[i]和Nums2[j]的大小。
    //  3.val小的那方指针+1
    //  4.直到遍历到中位数位置。返回中位数
    /////////
    //  时间复杂度为O(m+n) -> 不行 X
    ////////////////
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        int l1 = nums1.length;
        int l2 = nums2.length;
        int result = -1;
        int next = -1;

        if(l1 + l2 == 0){
            return result;
        }
        if(l1 == 0 && l2 ==1){ return nums2[0];}
        if(l2 == 0 && l1 ==1){ return nums1[0];}

        boolean isEven = false;
        if((l1+l2)%2 ==0){
            isEven = true;
        }
        int mid = ( (l1+l2)%2 ==0 ) ? ( (l1+l2)/2 ) : ( (l1+l2+1)/2 );

        int i=0;
        int j=0;
        while(i+j <= mid){    //result = mid-1, next = mid. 偶数数组需要next
            if(i<l1 && j<l2){    //nums1 和 nums2都还有数字
                if(nums1[i]<= nums2[j]){
                    result = next;
                    next = nums1[i];
                    i++;
                }else{
                    result = next;
                    next = nums2[j];
                    j++;
                }
            }else if(i<l1){ //l2空了
                result = next;
                next = nums1[i];
                i++;
            }else{  //l1空了
                result = next;
                next = nums2[j];
                j++;
            }
        }

        if(isEven){
            return (double)(result+next)/2 ;
        }
        return result;
    }



}
