package interview;

import java.util.*;

/*
堆盘子。设想有一堆盘子，堆太高可能会倒下来。因此，在现实生活中，盘子堆到一定高度时，我们就会另外堆一堆盘子。
请实现数据结构SetOfStacks，模拟这种行为。SetOfStacks应该由多个栈组成，并且在前一个栈填满时新建一个栈。
此外，SetOfStacks.push()和SetOfStacks.pop()应该与普通栈的操作方法相同
（也就是说，pop()返回的值，应该跟只有一个栈时的情况一样）。
进阶：实现一个popAt(int index)方法，根据指定的子栈，执行pop操作。

当某个栈为空时，应当删除该栈。当栈中没有元素或不存在该栈时，pop，popAt 应返回 -1.

示例1:

 输入：
["StackOfPlates", "push", "push", "popAt", "pop", "pop"]
[[1], [1], [2], [1], [], []]
 输出：
[null, null, null, 2, 1, -1]
示例2:

 输入：
["StackOfPlates", "push", "push", "push", "popAt", "popAt", "popAt"]
[[2], [1], [2], [3], [0], [0], [0]]
 输出：
[null, null, null, null, 2, 1, 3]

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/stack-of-plates-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class I0303_StackOfPlates {
    /////////////////
    //思路：
    //可以把每柱盘子看作一个堆栈元素，同时每个盘子是另一个堆栈的元素
    //救成了堆栈套堆栈的问题
    //1.大堆栈元素=盘子堆 <LinkedList>
    //2.小堆栈=每个盘子堆->元素=盘子    <ArrayDeque>
    ////////////////
    //Deque比Stack好用，由于Stack继承了Vector，而Vector是同步的，因此Stack比Deque慢。
    // 因此，在Java 5之后，推荐使用Deque替代Stack。
    //总之，Deque比Stack更加灵活、更加高效，并且支持更多的操作。
    ////////////////
    // 用stack大堆栈无法实现popAt
    // 1.尝试改用LInkedList
    ////////////////
    //stack也行，加个if，判断size大小
    ///////////

    private LinkedList<Deque> stacks;
    private Integer cap;


    public I0303_StackOfPlates(int cap) {
        this.stacks = new LinkedList<Deque>();
        this.cap = cap;
    }

    public void push(int val) {
        if(stacks.isEmpty()){
            ArrayDeque<Integer> plates = new ArrayDeque<>();
            plates.offerLast(val);
        }else if(!stacks.getLast().offerLast(val)){
            ArrayDeque<Integer> plates = new ArrayDeque<>();
            plates.offerLast(val);
        }
    }

    public int pop() {
        return (int) stacks.getLast().pollLast();
    }

    public int popAt(int index) {
        Iterator<Deque> iterator = stacks.iterator();
        ArrayDeque<Integer> temp = new ArrayDeque<>();
        int i=0;
        while(i!= index && iterator.hasNext()){
            i++;
            temp = (ArrayDeque<Integer>) iterator.next();
        }
        if(i== index){
            return  temp.pop();
        }else{
            return -1;
        }
    }

    /**
     * 以下是对代码修改部分的解释：
     *
     * 将stacks的类型从LinkedList<Deque>更改为LinkedList<ArrayDeque<Integer>>，以明确存储的栈中的元素类型为Integer。
     * 在push方法中，添加了对cap（栈的容量）的检查，确保cap大于0，否则不执行任何操作。
     * 在push方法中，使用stacks.add(newStack)而不是stacks.getLast().offerLast(val)来向stacks添加新栈。
     * 在pop方法中，检查stacks是否为空，如果为空则返回-1。
     * 在pop方法中，如果弹出元素后栈为空，就从stacks中删除该栈。
     * 在popAt方法中，检查给定的索引是否有效，如果无效则返回-1。
     * 在popAt方法中，如果弹出元素后栈为空，就从stacks中删除该栈。
     *
     * import java.util.*;
     *
     * public class I0303_StackOfPlates {
     *     private LinkedList<ArrayDeque<Integer>> stacks;
     *     private int cap;
     *
     *     public I0303_StackOfPlates(int cap) {
     *         this.stacks = new LinkedList<>();
     *         this.cap = cap;
     *     }
     *
     *     public void push(int val) {
     *         if (cap <= 0) {
     *             return;
     *         }
     *         if (stacks.isEmpty() || stacks.getLast().size() == cap) {
     *             ArrayDeque<Integer> newStack = new ArrayDeque<>();
     *             newStack.offerLast(val);
     *             stacks.add(newStack);
     *         } else {
     *             stacks.getLast().offerLast(val);
     *         }
     *     }
     *
     *     public int pop() {
     *         if (stacks.isEmpty()) {
     *             return -1;
     *         }
     *         int result = stacks.getLast().pollLast();
     *         if (stacks.getLast().isEmpty()) {
     *             stacks.removeLast();
     *         }
     *         return result;
     *     }
     *
     *     public int popAt(int index) {
     *         if (index < 0 || index >= stacks.size()) {
     *             return -1;
     *         }
     *         ArrayDeque<Integer> stack = stacks.get(index);
     *         int result = stack.pollLast();
     *         if (stack.isEmpty()) {
     *             stacks.remove(index);
     *         }
     *         return result;
     *     }
     * }
     */
}
