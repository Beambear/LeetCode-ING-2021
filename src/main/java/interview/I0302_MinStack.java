package interview;

import java.util.LinkedList;
import java.util.Stack;

/*
请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。


示例：

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/min-stack-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class I0302_MinStack {
    ///////////
    //思路：
    //由两个堆完成
    //1.正常记录stack情况
    //2.永远记录最新的最小值。如果当前值
    ///////////
    Stack<Integer> stacks;
    Stack<Integer> minStacks;
    public I0302_MinStack() {
        stacks = new Stack<>();
        minStacks = new Stack<>();
    }

    public void push(int x) {
        stacks.push(x);
        if(minStacks.isEmpty() || x<minStacks.peek()){
            minStacks.add(x);
        }else {
            minStacks.add(minStacks.peek());
        }
    }

    public void pop() {
        stacks.pop();
        minStacks.pop();
    }

    public int top() {
        return stacks.peek();
    }

    public int getMin() {
        return  minStacks.peek();
    }
}
