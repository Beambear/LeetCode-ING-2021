package practice;
/*
设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。

在链表类中实现这些功能：

get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/design-linked-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

////////////////////
//链表
//单向链表/双向链表
/////////////
public class P707_DesignLinkedList {

    //私有类，单向链表
    private class SinglyLinkedList{
        ///////////
        //Node类，包含两个属性和两个构造器
        //////////
        private class Node{
            int val;
            Node next;
            public Node(int val){
                this.val =val;
            }
            public Node(int val, Node next){
                this.val = val;
                this.next = next;
            }
        }


        /////////
        //单向链表
        //1.链表属性，两个指针head & tail
        //2.constructor:创建"零号"节点val=-1
        //3.addAtHead:判断head 是否等于-1（链表为"空"）
        //            true-> head = tail = Node(val).
        //            Else-> head = Node(val)
        //4.addAtTail:判断tail 是否等于-1（链表为“空”）
        //              true-> tail = head = temp.
        //              else-> tail.next = temp; tail = temp;
        //5.new method search: temp从head开始遍历
        //                      若index为空，temp = Node(-1);
        //                      返回temp; temp 为目标节点
        //6.get: return search(index).val;
        //7.addAtIndex: 若index=0 -> addAtHead;
        //              若head = -1 -> do nothing;
        //              else pre=search(index-1),
        //              若pre=-1 -> do nothing (没有前置节点插入index)
        //              else temp.next = pre.next; pre.next = temp;
        //8.deleteAtIndex: pre = search(index -1); cur = search(index);
        //              若 pre.val = -1 || cur.val = -1 || head = -1-> do nothing  没有前置节点/没有当前节点/没有链表
        //              else if(delete head)
        //              else if(delete tail)
        //              else if(between head&tail)pre.next = cur.next!=-1 ?cur.next:null，若cur没有next，pre.next = null
        /////////
        Node head;
        Node tail;
        public SinglyLinkedList() {
            head = new Node(-1);
            tail = head;
        }

        public int get(int index) {
            return search(index).val;
        }

        public void addAtHead(int val) {
            Node temp = new Node(val,head);
            if(head.val == -1){ //若链表为“空”
                temp.next = null;
                head = temp;
                tail = head;
            }else{
                head = temp;
            }
        }

        public void addAtTail(int val) {
            Node temp = new Node(val);
            if(tail.val == -1) {//若链表为“空”
                tail = temp;
                head = tail;
            }else{
                tail.next = temp;
                tail = temp;
            }
        }

        public void addAtIndex(int index, int val) {
            if(index ==0){
                addAtHead(val);
                return;
            }else if(head.val == -1){
                return; //list is empty and not add at tail, do nothing
            }
            Node pre = search(index-1);
            if(pre.val == -1){
                //do nothing
            }else if(pre.next == null){ //add at tail
                addAtTail(val);
                return;
            }else{
                Node temp = new Node(val);
                temp.next = pre.next;
                pre.next = temp;
            }
        }

        public void deleteAtIndex(int index) {
            Node pre = search(index-1);
            Node cur = search(index);
            if(pre.val == -1 || cur.val == -1 || head.val == -1){
                return;//no cur node or pre node or empty list, do nothing
            }else if(index ==0){//delete head while head is not empty
                if(head.next == null){//only 1 node in list
                    head = new Node(-1);
                    tail = head;
                }else{
                    head = head.next;
                }
                return;
            }else if(cur.next == null){//delete tail
                tail = pre;
                tail.next = null;
                return;
            }else{
                //delete between head & tail
                pre.next = cur.next.val != -1 ? cur.next : null;
            }
        }

        public Node search(int index){
            Node temp = head;
            for(int i=0;i<index;i++){
                if(temp == null){
                    return new Node(-1);
                }
                temp = temp.next;
            }
            return temp;
        }
    }
}

