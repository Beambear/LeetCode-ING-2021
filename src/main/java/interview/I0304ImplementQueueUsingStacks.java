package interview;

import java.util.ArrayDeque;

/*
实现一个MyQueue类，该类用两个栈来实现一个队列。


示例：

MyQueue queue = new MyQueue();

queue.push(1);
queue.push(2);
queue.peek();  // 返回 1
queue.pop();   // 返回 1
queue.empty(); // 返回 false

说明：

你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size 和 is empty 操作是合法的。
你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/implement-queue-using-stacks-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

    //////////////
    //思路：
    //  两个stack，常态下A储存元素，B为空。
    //  需要pop时， B.push( A.pop() ); -> B.pop(); -> A.push( b.pop() );
    /////////
public class I0304ImplementQueueUsingStacks {
    ArrayDeque<Integer> stackA;
    ArrayDeque<Integer> stackB;
    /** Initialize your data structure here. */
    public I0304ImplementQueueUsingStacks() {
        stackA = new ArrayDeque<>();
        stackB = new ArrayDeque<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackA.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int result = 0;
        if(empty()){
            result = -1;
        }else {
            aToB();
            result = stackB.pollLast();
            bToA();
        }
        return result;
    }

    /** Get the front element. */
    public int peek() {
        int result = 0;
        if(empty()){
            result = -1;
        }else {
            aToB();
            result = stackB.peekLast();
            bToA();
        }
        return result;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(stackA.isEmpty()){return true;}else{return false;}
    }

    private void aToB(){
        while(!stackA.isEmpty()){
            stackB.push(stackA.pollLast());
        }
    }

    private void bToA(){
        while(!stackB.isEmpty()){
            stackA.push(stackB.pollLast());
        }
    }
}
