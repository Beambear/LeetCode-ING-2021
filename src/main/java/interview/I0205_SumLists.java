package interview;

public class I0205_SumLists {
    /*
    给定两个用链表表示的整数，每个节点包含一个数位。
    这些数位是反向存放的，也就是个位排在链表首部。
    编写函数对这两个整数求和，并用链表形式返回结果。
    示例：
    输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
    输出：2 -> 1 -> 9，即912
    进阶：思考一下，假设这些数位是正向存放的，又该如何解决呢?

    示例：
    输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
    输出：9 -> 1 -> 2，即912

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/sum-lists-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    ////////////
    //思路：
    //数列反向存放，最左侧是个位数,就地相加
    //1. l1+l2， 获得链表new L1
    //2. 反制链表，获得result
    //例： l1=1->2->3->4->5; head=null
    //    l1=1->2->3->4 ; head =5（pointer 1)
    //    l1=2->3;  head = 5（pointer 1)->4（pointer2)->1（pointer3)
    //    l1=null;  head = 5（pointer 1)->4->3（pointer2)->2（pointer3)->1
    // /////////
    public ListNode addTwoNumbersA(ListNode l1,ListNode l2){
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        //相加
        int carry = 0;
        do{
            if(cur1.next == null){    //L1结束，L2还有
                cur1.next = cur2;
                break;
            } else if (cur2.next == null){//L2结束，L1还有
                cur1.next = cur1;
                break;
            } else {
                cur1.val = cur1.val + cur2.val + carry;
                if(cur1.val >9){
                    cur1.val = cur1.val-10;
                    carry = 1;
                }else {
                    carry = 0;
                }
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }while(cur1.next !=null || cur2.next != null);
        if(carry !=0){
            cur1.next = new ListNode(1);
            cur1 = cur1.next;
        }

        //此时l1是完成相加计算的结果
        //开始颠倒l1
        ListNode head = cur1;//确定新head,返回此head
        ListNode cutHead = head;
        cur1 = null;    //摘掉已被记录的l1尾部节点。
        ListNode cutTail = l1;  //l1的头，作为尾部链接节点
        head.next = cutTail;   //链接链表
        cutTail.next = null;   //清除多余节点
        if(l1.next != null){
            l1=l1.next; //删除l1的head
        }

        //颠倒L1
        ListNode left;
        ListNode right;
        while(l1 != null){
            left = l1;  //获得l1链表头部
            left.next = cutTail;    //left 链接cutTail
            cutTail = left; //移动cutTail指针

            if (left.next != null){
                right = left.next;  //指针right 寻找tail
                while(right.next != null){//找到tail
                    right = right.next;
                }
                //链接已有链表
                right.next=cutTail;
                cutHead.next = right;
                cutHead = cutHead.next;
            }
        }
        return head;
    }
    /**
     * 上述方法报错，阶段1相加的时候没法计算tail的数，如果携带carry会多出一位数。
     * 下面method是ChatGPT优化后的结果
     * 你的代码中存在死循环。具体来说，当 l1 或 l2 比另一个链表长时，你在循环中一直访问 cur2.next 或 cur1.next，
     * 但是这些指针可能已经到了链表的尾部，会导致空指针异常。
     * 另外，你的解法的时间复杂度为 $O(n^2)$，其中 $n$ 是两个链表中较长的那个的长度。这是因为你每次都要找到链表的尾部，
     * 而这个操作在最坏情况下需要扫描整个链表。
     * 一个更优的做法是在遍历两个链表时，同时维护一个进位值 carry。
     * 每次将两个节点的值相加再加上进位值，如果和大于等于 10，就将进位值设为 1。然后创建一个新节点，其值为和模 10，
     * 链接到结果链表的末尾，更新进位值和两个链表指针即可。当遍历完两个链表时，如果进位值不为 0，还需要创建一个新节点。
     * 这个做法的时间复杂度为 $O(n)$，其中 $n$ 是两个链表中较长的那个的长度。
     * 以下是改进后的代码：
     */
    public ListNode addTwoNumbersB(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            sum %= 10;
            tail.next = new ListNode(sum);
            tail = tail.next;
        }
        if (carry != 0) {
            tail.next = new ListNode(carry);
        }
        return dummy.next;
    }

    /////////////////////
    //思路2：
    //因为列表反制，最左侧是个位数
    //即可以从左到计算sum， 新的sum作为上一个sum的head。
    /////////////////////
    public ListNode addTwoNumbersC(ListNode l1, ListNode l2){
        ListNode cur = null;
        ListNode head = new ListNode(0);
        int carry = 0;
        int sum =0;
        while(l1 !=null || l2 != null){
            if(l1 == null){
                sum = l2.val + carry;
            }else if (l2 == null){
                sum = l1.val + carry;
            }else {
                sum = l1.val + l2.val + carry;
            }
            carry = sum%10;
            sum = sum/10;
            head.val=sum;
            head.next = cur;
            cur = head;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(carry != 0){
            head.val=1;
            head.next = cur;
        }
        return head;
    }
    /**
     * ChatGPT:
     * 在链表中，不能修改头结点的值，因此需要在计算 sum 时使用一个哑节点来替代头结点。
     * 具体来说，可以将 head 赋值为一个值为 0 的 ListNode，然后在计算 sum 时将其值修改为真正的结果。
     * 在返回结果时，返回哑节点的下一个节点即可。修改后的代码如下：
     */
    public ListNode addTwoNumbersD(ListNode l1, ListNode l2){
        ListNode cur = null;
        ListNode head = new ListNode(0);// 新建一个节点，它的下一个节点才是最终结果
        ListNode dummy = head; // 哑节点
        int carry = 0; // 进位
        int sum =0;// 记录两个链表中同一位的和
        while(l1 !=null || l2 != null){
            if(l1 == null){ // 如果链表1已经走到尽头，用0代替
                sum = l2.val + carry;
            }else if (l2 == null){  // 如果链表2已经走到尽头，用0代替
                sum = l1.val + carry;
            }else { // 如果两个链表都还有值，相加
                sum = l1.val + l2.val + carry;
            }
            carry = sum/10; // 记录进位
            sum = sum%10;   // 对10取余，得到当前位的数字
            head.next = new ListNode(sum); // 新建节点
            head = head.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if(carry != 0){
            head.next = new ListNode(carry); // 进位
        }
        return dummy.next; // 返回哑节点的下一个节点
    }
    /////////////////////////////////////////////////////////////////////
    //问题解决，身体错误。输出的结果依然是反着的，不用扭正。//
    // 所以并不需要在head前插入节点，直接依次向后加即可//
    //////////////////////////////////////////////////
}
