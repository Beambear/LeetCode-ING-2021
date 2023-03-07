package interview;

import java.util.HashSet;
import java.util.Set;

/*
给定一个链表，如果它是有环链表，实现一个算法返回环路的开头节点。若环不存在，请返回 null。

如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/linked-list-cycle-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class I0208_LinkedListCycle {
    /////////////
    //思路:
    //  用哈希表记录已遍历过的节点，
    //  若节点重复则返回该节点，说明已找到循环头
    //  当下个节点为null，则返回null
    /////////////
        public ListNode detectCycle(ListNode head){
            Set<ListNode> visited = new HashSet<ListNode>();
            ListNode cur = head;
             while(cur != null){
                 if(visited.contains(cur)){
                     return cur;
                 }else {
                     visited.add(cur);
                 }
                 cur = cur.next;
             }
             return null;
        }

    /**
     * Chat GPT 快慢针。
     * 具体没看到，leetcode解题里有
     */
    public ListNode detectCycleB(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 如果 slow 和 fast 相遇了，则说明链表有环
            if (slow == fast) {
                ListNode p = head;
                while (p != slow) {
                    p = p.next;
                    slow = slow.next;
                }
                return p;
            }
        }
        // 如果 fast 为空，说明链表没有环
        return null;
    }
}
