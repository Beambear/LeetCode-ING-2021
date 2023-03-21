package interview;
/*
动物收容所。有家动物收容所只收容狗与猫，且严格遵守“先进先出”的原则。在收养该收容所的动物时，收养人只能收养所有动物中“最老”（由其进入收容所的时间长短而定）的动物，或者可以挑选猫或狗（同时必须收养此类动物中“最老”的）。换言之，收养人不能自由挑选想收养的对象。请创建适用于这个系统的数据结构，实现各种操作方法，比如enqueue、dequeueAny、dequeueDog和dequeueCat。允许使用Java内置的LinkedList数据结构。

enqueue方法有一个animal参数，animal[0]代表动物编号，animal[1]代表动物种类，其中 0 代表猫，1 代表狗。

dequeue*方法返回一个列表[动物编号, 动物种类]，若没有可以收养的动物，则返回[-1,-1]。

示例1:

 输入：
["AnimalShelf", "enqueue", "enqueue", "dequeueCat", "dequeueDog", "dequeueAny"]
[[], [[0, 0]], [[1, 0]], [], [], []]
 输出：
[null,null,null,[0,0],[-1,-1],[1,0]]
示例2:

 输入：
["AnimalShelf", "enqueue", "enqueue", "enqueue", "dequeueDog", "dequeueCat", "dequeueAny"]
[[], [[0, 0]], [[1, 0]], [[2, 1]], [], [], []]
 输出：
[null,null,null,null,[2,1],[0,0],[1,0]]
说明:

收纳所的最大容量为20000

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/animal-shelter-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//////////////////
    //思路：
    //  因为每个宠物都有编号，所以每个物种分一个队列
    //  dequeueAny时比较head的编号，编号小的取出
    //  剩余情况直接取出该物种队列的head
    //
    //  边际： 注意列表为空的情况。
    //////////////////
public class I0306_AnimalShelter {
    Deque<Integer>  cat;
    Deque<Integer>  dog;
        public I0306_AnimalShelter() {
            this.cat = new LinkedList<Integer>();
            this.dog = new LinkedList<Integer>();
        }

        public void enqueue(int[] animal) {
            if(animal[1] == 0 ){    //is cat
                cat.addLast(animal[0]); //add animal #
            }else if(animal[1] == 1){
                dog.addLast(animal[0]); //add animal #
            }else{
                return;
            }
        }

        public int[] dequeueAny() {
            if(dog.isEmpty() && cat.isEmpty()){ //no any animal
                return new int[]{-1,-1};    //return -1,-1
            }else if(!dog.isEmpty() && cat.isEmpty()){ //has dogs but no cats
                return dequeueDog();
            }else if(dog.isEmpty() && !cat.isEmpty()){
                return dequeueCat();
            }
            // has both animal
            if(dog.peekFirst() < cat.peekFirst()){  //dequeue dog
                return dequeueDog();
            }else{  //dequeue catt
                return dequeueCat();
            }
        }

        public int[] dequeueDog() {
            if(dog.isEmpty()){
                return new int[]{-1,-1};
            }
            int num = dog.pollFirst();
            return new int[]{num,1};
        }

        public int[] dequeueCat() {
            if(cat.isEmpty()){
                return new int[]{-1,-1};
            }
            int num = cat.pollFirst();
            return new int[]{num,0};
        }
}
