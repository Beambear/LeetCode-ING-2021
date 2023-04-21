package practice;
/*
给你一棵以 root 为根的二叉树，二叉树中的交错路径定义如下：

选择二叉树中 任意 节点和一个方向（左或者右）。
如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。
改变前进方向：左变右或者右变左。
重复第二步和第三步，直到你在树中无法继续移动。
交错路径的长度定义为：访问过的节点数目 - 1（单个节点的路径长度为 0 ）。

请你返回给定树中最长 交错路径 的长度。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/longest-zigzag-path-in-a-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P1372_LongestZigzagPathInABinaryTree {

    int max;
    public int longestZigZag(TreeNode root){
        max=0;
        zigZagPath(root.left,0,0);//root为起点,0=左，深度=0
        zigZagPath(root.right,1,0);//root为起点,1=右，深度=0
        return max;
    }
    private void zigZagPath(TreeNode root, int dir,int depth){
        if(root ==null){
            return;
        }
        max = Math.max(max,++depth);
        if(dir ==0){    //之前向左
            zigZagPath(root.right,1,depth); //若zigZag方向->向右，并传递当前depth
            zigZagPath(root.left,0,0);//若不遵循zigZag方向->向左, depth归零
        }

        if(dir ==1){    //之前向右
            zigZagPath(root.right,0,depth); //若zigZag方向->向左，传递当前depth
            zigZagPath(root.left,1,0);//若不遵循zigZag方向->向右,depth归零
        }
    }
}
