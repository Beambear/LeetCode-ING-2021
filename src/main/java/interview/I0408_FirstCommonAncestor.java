package interview;
/*
设计并实现一个算法，找出二叉树中某两个节点的第一个共同祖先。不得将其他的节点存储在另外的数据结构中。注意：这不一定是二叉搜索树。

例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4]

    3
   / \
  5   1
 / \ / \
6  2 0  8
  / \
 7   4
示例 1:

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出: 3
解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
示例 2:

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
输出: 5
解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
说明:

所有节点的值都是唯一的。
p、q 为不同节点且均存在于给定的二叉树中。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/first-common-ancestor-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class I0408_FirstCommonAncestor {
    TreeNode ancestor;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        searchCommonAncestor(root,p,q);
        return ancestor;
    }

    private void searchCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root.left == null && root.right == null){
            //do nothing
        }else if(root.left != null && containsTargetNode(root.left,p)&& containsTargetNode(root.left,q)){
            searchCommonAncestor(root.left,p,q);
        } else if(root.right !=null && containsTargetNode(root.right,p)&& containsTargetNode(root.right,q)){
            searchCommonAncestor(root.right,p,q);
        }else if(root.left !=null && !containsTargetNode(root.left,p)&& !containsTargetNode(root.left,q)){
            // left node doesn't contain targets at all, do nothing
        }else if(root.right !=null && !containsTargetNode(root.right,p)&&!containsTargetNode(root.right,q)) {
            // right no doesn't contain targets att all, do nothing
        }else{
            ancestor = root;
        }
    }
    private boolean containsTargetNode(TreeNode root, TreeNode target){
        if(root.equals(target)){
            return true;
        }
        if(root.left != null){
            containsTargetNode(root.left,target);
        }
        if(root.right !=null){
            containsTargetNode(root.right,target);
        }
        return false;
    }

    /**
     * containsTargetNode 方法没有正确返回递归调用的结果，因此其实现可能无法找到正确的目标节点。
     *
     * 在 searchCommonAncestor 方法中，当 root 左子树和右子树都存在目标节点 p 和 q 时，没有继续向下搜索左子树或右子树。
     *
     * 当 root 不是目标节点，且它的左子树和右子树都不包含目标节点时，没有结束递归调用，可能会导致程序进入死循环。
     *
     * 以下是一个修改后的代码实现，它可以找到二叉树中任意两个节点的最近公共祖先：
     *
     * css
     * Copy code
     * public class I0408_FirstCommonAncestor {
     *     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
     *         if (root == null || root == p || root == q) {
     *             return root;
     *         }
     *
     *         TreeNode left = lowestCommonAncestor(root.left, p, q);
     *         TreeNode right = lowestCommonAncestor(root.right, p, q);
     *
     *         if (left != null && right != null) {
     *             return root;
     *         } else {
     *             return left != null ? left : right;
     *         }
     *     }
     * }
     * 这个实现中，我们首先检查 root 是否为 p 或 q，如果是，直接返回 root。否则，
     * 我们分别递归地搜索 p 和 q 在左子树和右子树中的位置。
     * 如果 p 和 q 都在左子树或右子树中，则继续向下递归；否则，我们找到了它们的最近公共祖先，返回它即可。
     */
}
