package interview;

import java.util.ArrayDeque;
import java.util.Deque;

/*
栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。

示例1:

 输入：
["SortedStack", "push", "push", "peek", "pop", "peek"]
[[], [1], [2], [], [], []]
 输出：
[null,null,null,1,null,2]
示例2:

 输入：
["SortedStack", "pop", "pop", "push", "pop", "isEmpty"]
[[], [], [], [1], [], []]
 输出：
[null,null,null,null,null,true]

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/sort-of-stacks-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
    /////////////////
    //思路:
    //  栈A 储存排序元素， 底部 < 顶部。
    //  栈B 空栈
    //  push新元素时，cur = popA. 比较 cur 和 new。
    //      当new > cur, cur进stack B， 继续循环
    //      当new <=cur, new进stack A, 并把stack B 全部放回A
    /////////////////
public class I0305_SortOfStacks {
    Deque<Integer> stackA;
    Deque<Integer> stackB;
    public I0305_SortOfStacks() {
        stackA = new ArrayDeque();
        stackB = new ArrayDeque();
    }

    public void push(int val) {
        if(stackA.isEmpty()){   //如果栈为空
            stackA.offerLast(val);
        }

        while(stackA.peek() < val && !stackA.isEmpty()){    //栈顶比当前小，且栈不为空
            stackB.offerLast(stackA.pollLast());    //栈顶数值暂存到stackB
        }
        //现在栈顶 >= 当前 或者 栈为空
        stackA.offerLast(val);  //栈A放入新值
        while(!stackB.isEmpty()){  //栈B暂存放回栈A
            stackA.offerLast(stackB.pollLast());
        }
    }

    public void pop() {
        stackA.pollLast();
    }

    public int peek() {
        return stackA.peek();
    }

    public boolean isEmpty() {
        return stackA.isEmpty();
    }


}
