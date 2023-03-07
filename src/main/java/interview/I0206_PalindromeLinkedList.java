package interview;
/*
编写一个函数，检查输入的链表是否是回文的。

示例 1：

输入： 1->2
输出： false
示例 2：

输入： 1->2->2->1
输出： true

进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/palindrome-linked-list-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class I0206_PalindromeLinkedList {
    ////////////////
    //思路:
    //新建两个链表，分别从头尾记录原生链表
    //最后比较两个链表是否全等
    //
    //就算是奇数回文，正中间的数字会被两个链表同时记录，不影响全等判断。
    //边际：如果head=null -> true
    ////////////////
    //同样的方法可以用Stack或者queue来做，好操作一些
    ///////////////
    public boolean isPalindrome(ListNode head){
        if(head ==null){
            return true;
        }
        ListNode ori = head;
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode lp = left;
        ListNode p = lp;
        ListNode rp = right.next;
        while(ori != null){
            lp.next = ori;
            lp=lp.next;
            p = lp.next;
            if(p == null){
                break;
            }
            while(p.next != null){
                p=p.next;
            }
            rp.next=p;
            rp=rp.next;
            ori = ori.next;
        }

        while(left !=null){
            if(left.val != right.val){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
    }
    /**
     * 你的代码有几个小问题，我帮你修改了一下，建议你看看并理解：
     *
     * java
     * Copy code
     * public class I0206_PalindromeLinkedList {
     *     //同样的方法可以用Stack或者queue来做，好操作一些
     *
     *     public boolean isPalindrome(ListNode head){
     *         if(head ==null){
     *             return true;
     *         }
     *
     *         ListNode slow = head, fast = head;
     *         while (fast != null && fast.next != null) {
     *             slow = slow.next;
     *             fast = fast.next.next;
     *         }
     *         if (fast != null) {
     *             slow = slow.next;
     *         }
     *
     *         ListNode left = head;
     *         ListNode right = reverseList(slow);
     *         while(right != null) {
     *             if(left.val != right.val) {
     *                 return false;
     *             }
     *             left = left.next;
     *             right = right.next;
     *         }
     *         return true;
     *     }
     *
     *     private ListNode reverseList(ListNode head) {
     *         ListNode pre = null;
     *         ListNode cur = head;
     *         while (cur != null) {
     *             ListNode next = cur.next;
     *             cur.next = pre;
     *             pre = cur;
     *             cur = next;
     *         }
     *         return pre;
     *     }
     * }
     * 这个方法的思路是使用快慢指针找到链表的中间节点，然后把中间节点之后的链表反转，最后和前半部分链表一一比较即可。
     * 在判断链表是否为奇数长度时，我们通过快慢指针的方式找到链表中间的节点。
     *
     * 具体地，我们使用两个指针slow和fast，初始值都指向链表头部，然后我们让slow每次前进一步，fast每次前进两步，直到fast指向链表末尾，这时候slow正好指向链表中间的节点。如果链表长度是偶数，那么slow指向的就是靠左边的那个中间节点。
     *
     * 在代码中，if (fast != null)语句用于判断链表长度是否为奇数。
     * 如果是奇数，那么fast指针在移动过程中就会先指向链表末尾的null，
     * 因此在while循环结束后，slow指向的是链表的正中央；如
     * 果是偶数，那么fast指针会停留在倒数第二个节点，
     * 所以在while循环结束后，slow指向的是中间两个节点中靠左边的那个。
     * 所以这个if语句可以判断链表长度的奇偶性，并据此调整slow指针的位置。
     */
    public boolean isPalindromeB(ListNode head){
              if(head ==null){
                  return true;
              }

              ListNode slow = head, fast = head;
              while (fast != null && fast.next != null) {
                  slow = slow.next;
                  fast = fast.next.next;
              }
              if (fast != null) {
                  slow = slow.next;
              }

              ListNode left = head;
              ListNode right = reverseList(slow);
              while(right != null) {
                  if(left.val != right.val) {
                      return false;
                  }
                  left = left.next;
                  right = right.next;
              }
              return true;
          }

        private ListNode reverseList(ListNode head) {
              ListNode pre = null;
              ListNode cur = head;
              while (cur != null) {
                  ListNode next = cur.next;
                  cur.next = pre;
                  pre = cur;
                  cur = next;
              }
              return pre;
          }
}
