package interview;
/*
给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
你不需要保留每个分区中各节点的初始相对位置。

示例 1：
输入：head = [1,4,3,2,5,2], x = 3
输出：[1,2,2,4,3,5]

示例 2：
输入：head = [2,1], x = 2
输出：[1,2]

提示：
链表中节点的数目在范围 [0, 200] 内
-100 <= Node.val <= 100
-200 <= x <= 200

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/partition-list-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class I0204_PartitionList {
    ////////////////////////
    //思路：
    //指针寻找第一个大于或等于x的结点. 记录preL 和 curL
    //指针继续寻找，遇到小于x的节点，记录preR, curR, curR.next
    //开始替换位置
    //  1.head->...->preL->curL->...->preR->curR->curR.next->...->tail   原列表
    //  2.head->...->preL->curR->curR.next->...->tail   把替换节点提前
    //                                curL->...->preR   落空列表
    //  3.head->...->preL->curR->curL->...->preR    更正列表顺序
    //                                curR.next->...->tail  落空列表
    //  4.head->...->preL->curR->curL->...->preR->curR.next->...->tail 新列表，完成拼接
    //  5.head->.........->preL->curL->...->preR->curR->...->tail  更新名字
    //      preL=curR;  curL 不变; preR不变; curR=curR.next;
    //返回 head
    ////////////////////////
    public ListNode partition(ListNode head, int x){
        ListNode preL = head;
        ListNode curL = head;
        //寻找第一个大于或等于x的节点
        while(curL.next != null && curL.val < x){  //右侧不为null且当前小于x
            preL = curL;        //pre=cur
            curL = curL.next;   //cur=cur.next
        }
        if(curL.next == null){
            return head;
        }
        //找到第一个大于等于节点 curL
        //继续寻找，遇到小于x的节点.
        ListNode preR = preL;
        ListNode curR = curL;
        while(curR.next !=null){//遍历整个ListNode
            if(curR.val <x  ){
                ListNode curRN = curR.next;
                preL.next = curR;   //步骤2.
                curR.next = curL;   //步骤3.
                preR.next = curRN;   //步骤4.
                preL = curR; //步骤5
                curR = curR.next;
            }
        }
        return head;
    }
    /**
     * 上述code有bug，下面是ChatGPT修改结果
     * 在 while(curL.next != null && curL.val < x) 这个循环中，
     * 你遗漏了对于当前节点值大于等于 x 的情况的处理，
     * 这将导致后面的步骤中如果链表中的所有节点都小于 x，会出现空指针异常。
     * 在步骤 2 中，你没有将 curL 的 next 指针更新，这会导致后面的节点丢失。
     * 在步骤 4 中，你应该将 preR.next 指向 curRN 而不是 curR，因为 curR 的 next 指针已经在步骤 3 中被修改了。
     */
    public ListNode partitionGPT(ListNode head, int x) {
        ListNode preL = null;
        ListNode curL = head;
        //寻找第一个大于或等于x的节点
        while (curL != null && curL.val < x) {
            preL = curL;
            curL = curL.next;
        }
        if (curL == null) {
            return head;
        }
        //找到第一个大于等于节点 curL
        //继续寻找，遇到小于x的节点.
        ListNode preR = curL;
        ListNode curR = curL.next;
        while (curR != null) {//遍历整个ListNode
            if (curR.val < x) {
                ListNode curRN = curR.next;
                preR.next = curR.next; //步骤 3
                if (preL == null) {
                    curR.next = head; //步骤 2
                    head = curR;
                } else {
                    curR.next = curL; //步骤 2
                    preL.next = curR; //步骤 5
                }
                preL = curR;
                curR = curRN;
            } else {
                preR = curR;
                curR = curR.next;
            }
        }
        return head;
    }

    //////////////////////
    //思路:
    //题目没有要求操作节点，所以可以直接交换节点内的值
    //1.找到最左侧大于等于x的节点，记录left
    //2.继续向右寻找小于x的节点，记录right
    //3.交换left.val <-> right.val.
    //  left = left.next
    //  right = right.next.
    //如此对节点链不做任何操作。
    ///////////////////////
        public ListNode partitionB(ListNode head, int x) {
            ListNode left = head;
            //寻找left
            while(left.next != null){   //遍历
                if(left.val >= x){      //找到left
                    break;
                }
                left = left.next;
            }
            //寻找right
            ListNode right = left;
            while(right.next !=null||right.val<x){
                if(right.val<x){        //找到right，交换值
                    int temp = left.val;
                    left.val = right.val;
                    right.val = temp;
                    left=left.next;     //指针右移
                }
                right = right.next;
            }
            return head;
        }
}
