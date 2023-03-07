package interview;
/*
    给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
    https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci/
 */
public class I0207_IntersectionOfTwoLinkedLists {
    ////////////////////
    //思路：
    //链表相交 = 焦点之后两条链表全等
    //可以从尾端开始比较，直到出现第一个不相等的值
    //可以用递归，可以用循环
    ////////////////////////
    public ListNode getIntersectionNodeA(ListNode headA, ListNode headB) {
        //递归法 recursion
        return findJoint(headA,headB,null);
    }

    private ListNode findJoint(ListNode headA, ListNode headB,ListNode tail){
        ListNode curA = headA;
        ListNode curB = headB;
        if(curA.next ==null || curB.next ==null){
            return tail;
        }


        while(curA.next != null){
            curA = curA.next;
        }
        while(curB.next != null){
            curB = curB.next;
        }

        if(curA.val == curB.val){
            tail = curA;
            curA=null;
            curB=null;
            return findJoint(headA,headB,tail);
        }
        return curA;
    }

    /**
     * 下面是一个时间复杂度 O(n)，空间复杂度 O(1) 的解法：
     *
     * 首先，我们计算出两个链表的长度，并求出它们的长度差 diff。然后将较长的链表先走 diff 步，这样两个链表剩下的长度就一样了。
     *
     * 接着，我们同时遍历两个链表，当两个指针指向的节点相同时，就找到了它们的相交节点。
     *
     * 代码如下：
     */
    public ListNode getIntersectionNodeB(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) { // 如果有一个链表为空，那么它们不可能相交
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) { // 如果 pA 和 pB 不相等，就一直循环下去
            pA = pA == null ? headB : pA.next; // 如果 pA 到达链表尾部，就将 pA 指向 headB，否则就移动 pA 到下一个节点
            pB = pB == null ? headA : pB.next; // 如果 pB 到达链表尾部，就将 pB 指向 headA，否则就移动 pB 到下一个节点
        }
        return pA; // 最后返回 pA 或 pB 都可以，因为此时它们已经相等了
    }
}
