package interview;
/*
    给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。

示例 1：

输入: num = 1775(110111011112)
输出: 8
示例 2：

输入: num = 7(01112)
输出: 4

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/reverse-bits-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class I0503_ReverseBits {
    //////////////////
    //思路：
    //  把binary num分成三个部分，left mid right
    //  记录1出现的次数， 每次记录玩后 num>>
    //  从left开始记，
    //      出现0 -> right = mid,
    //                   mid = left,
    //                   left = count
    //  最长1为left+mid+right+1
    ///////////////////
    //  边际情况： num=0 -> res=1
    //           num全是1，count最多32.
    //////////////////

    public int reverseBits(int num){
        int left=0;
        int right=0;
        int max =1;
        for(int i=0;i<32;i++){ //num 位运算结束前
            if ( (num&1) != 0){    //最右位=1
                left++;     //计数+1
            }else{          //最右位=0
                right = left;
                left = 0;
            }
            max=Math.max(left+1+right,max);
            num=num>>1;     //num 右移
        }
        return Math.min(max,32);
    }
}
