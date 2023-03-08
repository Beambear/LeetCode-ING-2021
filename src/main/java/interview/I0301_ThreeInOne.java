package interview;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

/*
三合一。描述如何只用一个数组来实现三个栈。

你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。
stackNum表示栈下标，value表示压入的值。

构造函数会传入一个stackSize参数，代表每个栈的大小。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/three-in-one-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class I0301_ThreeInOne {
    ////////////////////////
    //思路：
    //1.3个stack把数组均分为三段。 1111111111111->2222222222->3333333333
    //2.3个stack轮流出现在数组里。 1->2->3->1->2->3->1->2->3->1->2->3->1->2->3->
    //  2优点更多， 管理及扩展更方便，不会意外导致stack之间污染(但是本题不需要）
    //
    // notes： 一开始数组内容为null，没法遍历，所以需要额外一个数组记录位置
    ////////////////////////
    int stackSize;
    int[] obj;
    int[] tail;
    public I0301_ThreeInOne(int stackSize) {//构造函数
        this.stackSize = stackSize;
        obj = new int[3*stackSize];
        tail = new int[]{-1, -1, -1};
    }

    //用方法2储存
    public void push(int stackNum, int value) {
        int pos = 3*(tail[stackNum]+1)+stackNum;
        if(pos<obj.length){
            obj[pos] = value;
            tail[stackNum]++;
        }
    }

    public int pop(int stackNum) {
        int pos = 3*(tail[stackNum])+stackNum;
        if(pos<0){
            return -1;
        }
        int cur = obj[pos];
        tail[stackNum]--;
        return cur;
    }

    public int peek(int stackNum) {
        int pos = 3*(tail[stackNum])+stackNum;
        int cur = pos<0 ? -1 : obj[pos];
        return cur;
    }

    public boolean isEmpty(int stackNum) {
        int pos = 3*(tail[stackNum])+stackNum;
        return pos<0 ? true : false;
    }
}
