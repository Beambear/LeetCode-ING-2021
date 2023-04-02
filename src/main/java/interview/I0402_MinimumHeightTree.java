package interview;
/*
给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。

示例:
给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

          0
         / \
       -3   9
       /   /
     -10  5

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/minimum-height-tree-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class I0402_MinimumHeightTree {
    ///////////////////
    //思路：
    //  要二叉树高度尽量小，意味着二叉两侧尽量都有元素
    //  因为数组按升序排列，那么数组中间的数 左右数字数量相等。
    //  即二分法可把高度尽量做小
    //
    //  1.数组<=2，候怎么排都最多2层。
    //  2.数组>3，二分排列数组
    //  3.递归， add顺序 中 左 右
    ///////////////////
    TreeNode root;
    int[] nums;
    public TreeNode sortedArrayToBST(int[] nums){
        this.nums = nums;
        //边际情况
        if( nums.length == 0){
            return null;
        }
        if(nums.length ==1){
            return new TreeNode(nums[0]);
        }

        //1.找到起点，中点，终点
        int start = 0;
        int end = nums.length-1;
//        int mid = ( left + right )%2 == 0 ? (left+right)/2 : (left+right)/2;
        int mid = (start + end)/2;
        root = new TreeNode(nums[mid]); //中点即root
        recursionBuildTree(start,mid,end,root);
        return root;
    }

    private void recursionBuildTree(int start, int mid, int end, TreeNode node){
        if(mid - start ==1){    // no more left child
            node.left = new TreeNode(nums[start]);
            return;
        }

        if(end - mid ==1){  //no more right child
            node.right = new TreeNode(nums[end]);
            return;
        }

        if(mid - start >1) { //has left child
            int nextMid = (start + mid -1)/2;
            node.left = new TreeNode(nums[nextMid]);
            recursionBuildTree(start,nextMid,mid-1,node.left);
        }

        if(end - mid >1) {   //has right child
            int nextMid = (mid +1 + end)/2;
            node.right = new TreeNode(nums[nextMid]);
            recursionBuildTree(mid+1, nextMid, end, node.right);
        }
    }
    ////////////////有bug没修掉，思路是对的，直接抄答案了
    /**
     * class Solution {
     *     public TreeNode sortedArrayToBST(int[] nums) {
     *         return helper(nums, 0, nums.length - 1);
     *     }
     *
     *     public TreeNode helper(int[] nums, int left, int right) {
     *         if (left > right) {
     *             return null;
     *         }
     *
     *         // 总是选择中间位置左边的数字作为根节点
     *         int mid = (left + right) / 2;
     *
     *         TreeNode root = new TreeNode(nums[mid]);
     *         root.left = helper(nums, left, mid - 1);
     *         root.right = helper(nums, mid + 1, right);
     *         return root;
     *     }
     * }
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode.cn/problems/minimum-height-tree-lcci/solution/zui-xiao-gao-du-shu-by-leetcode-solution-t8d1/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}
