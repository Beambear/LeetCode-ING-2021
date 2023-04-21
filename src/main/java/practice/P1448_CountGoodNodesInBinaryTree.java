package practice;

import interview.TreeNode;

/*
给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。

「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。

 

示例 1：



输入：root = [3,1,4,3,null,1,5]
输出：4
解释：图中蓝色节点为好节点。
根节点 (3) 永远是个好节点。
节点 4 -> (3,4) 是路径中的最大值。
节点 5 -> (3,4,5) 是路径中的最大值。
节点 3 -> (3,1,3) 是路径中的最大值。
示例 2：



输入：root = [3,3,null,4,2]
输出：3
解释：节点 2 -> (3, 3, 2) 不是好节点，因为 "3" 比它大。
示例 3：

输入：root = [1]
输出：1
解释：根节点是好节点。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/count-good-nodes-in-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P1448_CountGoodNodesInBinaryTree {
    int count;
    public int goodNodes(TreeNode root){

        if(root == null){
            return 0;
        }
        count =1;
        inOrder(root,root.val);
        return count;
    }

    private void inOrder(TreeNode root, int pathMax){

        if (root.left != null){//left has nodes
            if(root.left.val >= pathMax){
                count++;
                inOrder(root.left, root.left.val);
            }else{
                inOrder(root.left,pathMax);
            }
        }

        if(root.right != null) {//right has node
            if(root.right.val >= pathMax){
                count++;
                inOrder(root.right,root.right.val);
            }else {
                inOrder(root.right,pathMax);
            }
        }
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
