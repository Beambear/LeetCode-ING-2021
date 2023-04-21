package practice;
/*
一位老师正在出一场由 n 道判断题构成的考试，每道题的答案为 true （用 'T' 表示）或者 false （用 'F' 表示）。老师想增加学生对自己做出答案的不确定性，方法是 最大化 有 连续相同 结果的题数。（也就是连续出现 true 或者连续出现 false）。

给你一个字符串 answerKey ，其中 answerKey[i] 是第 i 个问题的正确结果。除此以外，还给你一个整数 k ，表示你能进行以下操作的最多次数：

每次操作中，将问题的正确答案改为 'T' 或者 'F' （也就是将 answerKey[i] 改为 'T' 或者 'F' ）。
请你返回在不超过 k 次操作的情况下，最大 连续 'T' 或者 'F' 的数目。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/maximize-the-confusion-of-an-exam
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P2024_MaximizeTheConfusionOfAnExam {
    /////////
    //思路：
    //
    //
    //
    /////////

    public int maxConsecutiveAnswersGPT(String answerKey, int k){
        int[] count = new int[2];
        int left =0;
        int max =0;
        for(int right = 0;right<answerKey.length();right++){ //右指针到尽头之前
            if(answerKey.charAt(right) == 'T'){// right++
                count[0]++;
            }else{
                count[1]++;
            }

            while(Math.min(count[0],count[1]) > k){ //超过可更改上限，左指针++
                char cur = answerKey.charAt(left);
                if(cur == 'T'){
                    count[0]--;
                }else{
                    count[1]--;
                }
                left++;
            }
            int range = right -left +1; //窗口大小
            max = Math.max(range,max);
        }
        return max;
    }

    public int maxConsecutiveAnswers(String answerKey, int k){
        int head=0;    //指针
        int index =0;   //下个head
        boolean indexChanged = false;
        int max =0;
        while(index != -1){
            head = index;
            int indexNew = -1;//若之后index不再更新，则遍历结束
            char compare = answerKey.charAt(head);
            int move = k;
            int count =0;
            indexChanged = false;
            while(head<answerKey.length() && move!=-1 ){   //String有长度，move没消耗完
                if(compare != answerKey.charAt(head)){  //出现不同
                    move--; //减少操作次数
                    if(move == -1){ //如果超过操作次数了
                        continue;
                    }
                    count++;    //加长度
                    if(!indexChanged){
                        indexNew = head;
                        indexChanged=true;
                    }
                }else{  //相同
                    count++;
                }
                head++;
            }

            if(move>0){    //走到底了，但move还有剩余，向前做变化,同时index没更新过
                int i=index-1;
                while(i>=0&&move >0){//找到当前头部
                    if(compare != answerKey.charAt(i)){
                        move --;    //消耗move
                    }
                    i--;    //指针左移
                    count++;//计数++
                }
            }
            index = indexNew;
            if(count>max){//比较
                max = count;
            }
        }
        return max;
    }
}
