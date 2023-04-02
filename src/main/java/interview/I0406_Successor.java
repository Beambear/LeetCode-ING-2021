package interview;
/*
设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。

如果指定节点没有对应的“下一个”节点，则返回null。

示例 1:

输入: root = [2,1,3], p = 1

  2
 / \
1   3

输出: 2
示例 2:

输入: root = [5,3,6,2,4,null,null,1], p = 6

      5
     / \
    3   6
   / \
  2   4
 /
1

输出: null

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/successor-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

作者：LeetCode-Solution
链接：https://leetcode.cn/problems/legal-binary-search-tree-lcci/solution/he-fa-er-cha-sou-suo-shu-by-leetcode-sol-y1xm/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class I0406_Successor {
    ///////////////////
    //思路：
    //  中序是按 左->中->右的顺序遍历节点。
    //  找指定节点的下一个节点=找指定节点的右节点
    //  1.按中序遍历寻找指定节点
    //  2.判断指定节点是否有右子节点
    //      有->判断右子节点是否有左子节点
    //          有->右节点的左子节点 return
    //          无->右节点  return
    //      无->
    /////////////////
    //二叉搜索树的中序遍历，节点是从小到大依次排列的。
    //那么二叉搜索树中的节点的中序后继节点，就是比它大的最小的那个，这在BST中体现为，
    /**
     *若节点存在右子树，那么该最小值为右子树的最左叶节点；若无右子树，该最小值为进左子树时的父节点；再没有就是空了。
     */
     //我们维护一个进左子树时的父节点即可。 （最后一个比p大的父节点）
    //
    //作者：himymBen
    //链接：https://leetcode.cn/problems/successor-lcci/solution/pythonjavajavascriptgo-by-himymben-1h2p/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    //
    ////////////////
    //新思路：
    //  先找到p，当前节点比P大 ->进左节点， 记录为最后父节点
    //                 比P小->进右节点
    //  直到没有节点了都没找到P -> return null;
    //  找到P后，检查是否有右节点
    //      有->返回右节点最深的左侧子节点
    //      无->返回最后父节点
    ///////////
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p){
        TreeNode nodeAncestor = null;
        boolean hasP = false;
        //寻找P
        while(!hasP){
            if(root.val > p.val){   //当前比P大，向左寻找
                if(root.left == null){//找不到p
                    return null;
                }
                nodeAncestor = root;
                root = root.left;
            }else if(root .val == p.val){//找到目标节点
                hasP = true;
            }else if(root.val < p.val){//当前比P小，向右寻找
                if(root.right == null){
                    return null;
                }
                root = root.right;
            }
        }

        //寻找下个节点
        if(root.right == null){
            return nodeAncestor;
        }
        TreeNode result = root.right;
        while(result.left !=null){
            result = result.left;
        }
        return result;
    }
    /**
     * 自我优化后
     */
    public TreeNode inorderSuccessorB(TreeNode root, TreeNode p){
        TreeNode result = null;
        //寻找P
        while(true){
            if(root.val > p.val){   //当前比P大，向左寻找
                if(root.left == null){//找不到p
                    return null;
                }
                result = root;
                root = root.left;
            }else if(root .val == p.val){//找到目标节点
                if(root.right == null){
                    return result;
                }
                result = root.right;
                while(result.left !=null){
                    result = result.left;
                }
                return result;
            }else if(root.val < p.val){//当前比P小，向右寻找
                if(root.right == null){
                    return null;
                }
                root = root.right;
            }
        }

        //寻找下个节点

    }
}
