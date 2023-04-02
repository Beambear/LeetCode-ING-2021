package interview;

import java.util.Deque;
import java.util.LinkedList;

/*
    给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。

 

示例：

输入：[1,2,3,4,5,null,7,8]

        1
       /  \
      2    3
     / \    \
    4   5    7
   /
  8

输出：[[1],[2,3],[4,5,7],[8]]

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/list-of-depth-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class I0403_ListOfDepth {
    /////////////////
    //思路:
    //  输入是 treeNode，输出为链表。
    //  每个元素是单层的所有节点
    //  -> 广度优先 BSF
    //
    //  1.创建queue，记录搜索到的node
    //  2.从root开始，判断是否又左右child
    //      有便放入queue
    //      无则放入-1
    //  3.由于是二叉树，每一层都是2^n个元素
    //      所以该层轮完了便进入下一层
    ///////////
    public ListNode[] listOfDepth(TreeNode tree)    {
        Deque<TreeNode>queueCur = new LinkedList();    //当前层
        Deque<TreeNode>queueNext = new LinkedList();   //下一层
        Deque<ListNode> list = new LinkedList<>();  //result 链表
        int layer = 0;
        if(tree == null){   // no tree
            return new ListNode[0];
        }
        //has tree
        queueCur.offerFirst(tree);  //加进queue

        //开始遍历二叉树
        while(! queueCur.isEmpty()){    //队列不为空
            TreeNode curNode = queueCur.pollFirst();    //BSF 得到当前node
            ListNode head = new ListNode(curNode.val);     //加进链表
            ListNode cur = head;    //移动指针
            list.add(head); //头部指针放入链表
            while(! queueCur.isEmpty()){    //遍历当前层
                if(curNode.left != null){   //有左侧子节点
                    queueNext.offerLast(curNode.left);  //记入下一层的queue
                    cur.next = new ListNode(curNode.left.val);  //加进result链表
                    cur = cur.next;
                }
                if(curNode.right != null){  //有右侧子节点
                    queueNext.offerLast(curNode.right); //记入下一层的queue
                    cur.next = new ListNode(curNode.right.val); //加进result链表
                    cur = cur.next;
                }
            }
            //若有下一层
            if(!queueNext.isEmpty()){
                layer++;
                queueCur = queueNext;
                queueNext = new LinkedList<>();
            }
        }

        //链表转ListNode[]
        ListNode[] result = list.toArray(new ListNode[layer]);
        for(int i=0;i<=layer;i++){
            ListNode curLayer = list.pollFirst();
            while(curLayer != null ){
                result[i]= curLayer;
            }
        }
        return result;
    }

    /**
     *  GPT优化后更干净和高效。
     *  queueCur和queueNext合并为一个queue，用size记录当前层的大小。
     *  next的元素可直接加入queue，因为size的限制不会被遍历到。
     */
//    public ListNode[] listOfDepth(TreeNode tree)    {
//        Queue<TreeNode> queue = new LinkedList<>(); // 当前层节点队列
//        List<ListNode> resultList = new ArrayList<>(); // 存放每一层节点的链表
//        if(tree == null){   // no tree
//            return new ListNode[0];
//        }
//        //has tree
//        queue.offer(tree);  //加进queue
//
//        //开始遍历二叉树
//        while(!queue.isEmpty()){    //队列不为空
//            int size = queue.size();
//            ListNode head = null, tail = null;
//            for(int i = 0; i < size; i++) { //遍历当前层
//                TreeNode curNode = queue.poll(); //BSF 得到当前node
//                ListNode node = new ListNode(curNode.val); //加进链表
//                if(head == null) {
//                    head = node;
//                    tail = node;
//                } else {
//                    tail.next = node;
//                    tail = node;
//                }
//                if(curNode.left != null) {   //有左侧子节点
//                    queue.offer(curNode.left); //加入下一层的queue
//                }
//                if(curNode.right != null) {  //有右侧子节点
//                    queue.offer(curNode.right); //加入下一层的queue
//                }
//            }
//            resultList.add(head);
//        }
//
//        //链表转ListNode[]
//        ListNode[] result = new ListNode[resultList.size()];
//        return resultList.toArray(result);
//    }
}
