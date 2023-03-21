package practice;
/*
给你两个非空 的链表，表示两个非负的整数。

它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储一位数字。

请你将两个数相加，并以相同形式返回一个表示和的链表。

你可以假设除了数字 0 之外，这两个数都不会以 0开头。

示例 1：
输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.
示例 2：

输入：l1 = [0], l2 = [0]
输出：[0]

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/add-two-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P2_AddTwoNumbers {
    private class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){ this.val = val;}
        ListNode(int valm, ListNode next){ this.val = val; this.next = next;}
    }

    //////////////
    //不明白，为什么这个method在ListNode长短不统一的时候会跳过计算短列表的最后一个数字
    //////
    public ListNode addTwoNumbersF(ListNode l1,ListNode l2){
        ListNode sumList = new ListNode(0);
        ListNode sumHead = sumList; //don't move
        ListNode h1 = l1;
        ListNode h2 = l2;
        int carry =0;
        while(h1 != null && h2 != null){
            int sum =0;
            if(h1 != null && h2 != null){
                sum = h1.val + h2.val + carry;
                h1 = h1.next;
                h2 = h2.next;
            }else if(h1 == null && h2 != null){
                sum = h2.val + carry;
                h2 = h2.next;
            }else if(h1 != null && h2 == null){
                sum = h1.val + carry;
            }
            carry = sum/10;
            sum = sum%10;
            sumList.next = new ListNode(sum);
            sumList = sumList.next;
        }
        if(carry ==1){
            sumList.next = new ListNode(1);
        }
        return sumHead.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumList = new ListNode(0);
        ListNode sumHead = sumList;
        ListNode h1 = l1;
        ListNode h2 = l2;
        int carry =0;
        while(h1 != null || h2 != null){
            int a = 0;
            int b = 0;
            int sum =0;
            if(h1 != null){
                a=h1.val;
                h1 = h1.next;
            }
            if(h2 != null){
                b=h2.val;
                h2 = h2.next;
            }
            sum = a+b+carry;
            carry = sum/10;
            sum = sum%10;
            sumList.next = new ListNode(sum);
            sumList = sumList.next;
        }
        if(carry ==1){
            sumList.next = new ListNode(1);
        }
        return sumHead.next;
    }
}
