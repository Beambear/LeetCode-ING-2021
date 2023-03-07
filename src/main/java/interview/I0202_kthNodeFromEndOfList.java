package interview;

import java.util.Stack;

/*
实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。

注意：本题相对原题稍作改动

示例：
输入： 1->2->3->4->5 和 k = 2
输出： 4

说明：
给定的 k保证是有效的。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/kth-node-from-end-of-list-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * Definition for singly-linked list.
 *class ListNode {
 *      int val;
 *    ListNode next;
 *    ListNode(int x) { val = x; }
 * }
 */
public class I0202_kthNodeFromEndOfList {
    /////////////////
    //思路:
    //1.建立stack，把Node所有元素push进去。
    //2.pop k个， 第k个则是倒数第k个。
    //3.返回第k个
    //
    //临界考虑：
    //1.若head = null， 返回 null
    //2.若head.next = null, 返回head
    ////////////////
    public int kthToLast(ListNode head, int k ){
//        if(head == null){
//            return null;
//        }
        Stack<Integer> nums = new Stack<Integer>();
        ListNode i = head;
        while(i.next != null){
            nums.push(i.val);
            i=i.next;
        }
        nums.push(i.val);
        while(k>1){
            nums.pop();
            k--;
        }
        return nums.peek();
    }

    ////////////////////////
    //思路：
    //双指针i=j=head
    //j先单独出发前进k个节点
    //i和j同时前进，当j.next = null的时候 返回i
    ////////////////////////
    public int kthToLastB(ListNode head, int k ){
        ListNode pre = head;
        ListNode cur = head;
        for(int j=1;j<k;j++){
            pre = pre.next;
        }
        while(pre.next != null){
            pre = pre.next;
            cur = cur.next;
        }
        return cur.val;
    }
}