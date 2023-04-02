package interview;

import java.util.LinkedList;

/*
实现一个函数，检查一棵二叉树是否为二叉搜索树。

示例 1:
输入:
    2
   / \
  1   3
输出: true
示例 2:
输入:
    5
   / \
  1   4
     / \
    3   6
输出: false
解释: 输入为: [5,1,4,null,null,3,6]。
     根节点的值为 5 ，但是其右子节点值为 4 。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/legal-binary-search-tree-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class I0405_LegalBinarySearchTree {
    ///////////////
    //  思路：二叉搜索树，即数字按左小右大排列
    //  不能只查单个节点的左右，
    //  可以存在节点A,B, B>A. 但B的左节点也>A
    //
    //  尝试把二叉树还原成数组，再检查是否按增序排列
    //  1.链表比较容易实现中间穿插的功能
    //  2.root为中点， root.left -> addToLeft
    //               root.right -> addToRight
    //  3.遍历链表，检查是否按序排列
    /////////////////

    LinkedList<Integer> nums;
    public boolean isValidBST(TreeNode root){
        if(root == null){
            return true;
        }

        nums = new LinkedList<>();
        nums.add(root.val);
        searchTree(root); //展开二叉树
        int[] numsArray = new int[nums.size()];
        for(int i=0;i<nums.size();i++){
            numsArray[i]=nums.get(i);
        }
        int pre = numsArray[0];
        for(int i=1;i<numsArray.length;i++){
            if(numsArray[i]<=pre){
                return false;
            }else{
                pre = i;
            }
        }
        return true;
    }

    private void searchTree(TreeNode root){
        if(root.left != null){
            int index= nums.indexOf(root.val);//找到根节点位置
            nums.add(index,root.left.val);//添加在根节点左侧
            searchTree(root.left);  //继续探子节点
        }

        if(root.right !=null){
            int index =nums.indexOf(root.val);
            nums.add(index+1,root.right.val);
            searchTree(root.right);
        }

    }

    /**
     * GPT优化版
     */
    public boolean isValidBSTB(TreeNode root) {
        inorder(root);
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) <= nums.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        nums.add(node.val);
        inorder(node.right);
    }

}
