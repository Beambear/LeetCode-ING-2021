package interview;

import java.util.HashSet;
import java.util.Set;

/*
编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。

示例1:

 输入：[1, 2, 3, 3, 2, 1]
 输出：[1, 2, 3]
示例2:

 输入：[1, 1, 1, 1, 2]
 输出：[1, 2]
提示：

链表长度在[0, 20000]范围内。
链表元素在[0, 20000]范围内。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/remove-duplicate-node-lcci
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
public class I0201_RemoveDuplicate {
    //////////////
    //思路：
    //暴力双指针双循环
    /////
    public ListNode removeDuplicateNodesA(ListNode head){
        ListNode i = head;
        while (i != null){
            ListNode j = i;
            while(j.next != null){
                if(i.val == j.next.val){
                    j.next = j.next.next;
                }else {
                    j = j.next;
                }
            }
            i = i.next;
        }
        return head;
    }

    ///////////////
    //思路：
    //单指针哈希表
    //////////////
    public ListNode removeDuplicateNodesB(ListNode head){
        if(head ==null){
            return head;
        }
        Set<Integer> occurred = new HashSet<Integer>(); //创建哈希表
        occurred.add(head.val); //记录首个元素
        ListNode i = head;
        while(i.next != null){
            ListNode cur = i.next;  //待检查节点
            if(occurred.add(cur.val)){  //如果哈希成功表添加了新元素
                i=i.next;
            }else {
                i.next = i.next.next;
            }
        }
        return head;
    }
}
