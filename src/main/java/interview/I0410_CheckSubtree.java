package interview;
/*
检查子树。你有两棵非常大的二叉树：T1，有几万个节点；T2，有几万个节点。设计一个算法，判断 T2 是否为 T1 的子树。

如果 T1 有这么一个节点 n，其子树与 T2 一模一样，则 T2 为 T1 的子树，也就是说，从节点 n 处把树砍断，得到的树与 T2 完全相同。

注意：此题相对书上原题略有改动。

示例1:

 输入：t1 = [1, 2, 3], t2 = [2]
 输出：true
示例2:

 输入：t1 = [1, null, 2, 4], t2 = [3, 2]
 输出：false

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/check-subtree-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class I0410_CheckSubtree {
    //////////////
    //假设树的节点不会有相同值
    //思路：
    //  先在T1里找到与T2root数值相同的节点
    //  判断T2接下来的子树是否于T1相等
    ////////////
    boolean sameNode;
    public boolean checkSubTree(TreeNode t1, TreeNode t2){
        sameNode = false;
        TreeNode t1S = hasSameNode(t1,t2);
        if (!sameNode){
            return false;
        }
        return isSubTree(t1S,t2);
    }

    private TreeNode hasSameNode(TreeNode t1, TreeNode t2){
        if(t1.val == t2.val){
            sameNode = true;
            return t1;
        }
        hasSameNode(t1.left,t2);
        hasSameNode(t2.right,t2);
        return null;
    }

    private boolean isSubTree(TreeNode t1S,TreeNode t2){
        if(t1S != t2){
            return false;
        }
        if(t2.left != null){

        }
        return false;
    }
}
