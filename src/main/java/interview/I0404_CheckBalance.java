package interview;

import java.util.Deque;
import java.util.LinkedList;

/*
实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。


示例 1:
给定二叉树 [3,9,20,null,null,15,7]
    3
   / \
  9  20
    /  \
   15   7
返回 true 。
示例 2:
给定二叉树 [1,2,2,3,3,null,null,4,4]
      1         root
     / \
    2   2       branch_1    diff=0  ;root
   / \
  3   3         branch_2    diff=1  ;branch_1   diff=1
 / \
4   4                               ;branch_2   diff=2
返回 false 。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/check-balance-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class I0404_CheckBalance {
    ////////////////////
    //思路:
    //  两颗子树有4个节点
    //  root 不用判定， layer 1也不用判定
    //  layer2开始，需要判定n组。 n=2^(layer-1)
    //  当同组里出现了null与非null时， -> false
    ///////////////////
    //  有点复杂，弃之
    //  用土方法，找到每个点，硬往下算两层
    //  如果branch_1 都有子节点，那该node是balanced
    //  如果branch_1 缺少一个字节点且branch_2不为空 -> false
    ///////////////////
    public boolean isBalanced(TreeNode root){
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean result = true;
        while(!queue.isEmpty() && result==true){
            TreeNode cur = queue.pollFirst();
            result = isBalancedNode(cur);
            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right !=null){
                queue.offer(cur.right);
            }
        }
        return result;
    }

    private boolean isBalancedNode(TreeNode root){
        //如果branch_1子节点齐全，或者该点没有任何子节点, return true;
        /**
         * 好像可以不用判断，只有两种情况为false，其他都是true
         */
//        if((root.left!=null&&root.right!=null) || (root.left==null&&root.right ==null)){
//            return true;
//        }
        //branch_1有且仅有一个子节点
        //检查branch_1.left
        if((root.right ==null && root.left!=null) && (root.left.left!=null || root.left.right!=null)){
            return false;
        }
        //检查branch_2.right
        if((root.left ==null && root.right!=null) && (root.right.left!=null || root.right.right!=null)){
            return false;
        }
        return true;
    }

    /**
     * 上面又问题，，会漏掉很多情况。
     */
    public boolean isBalancedB(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }
}
