package interview;
/*
给定两个整型数字 N 与 M，以及表示比特位置的 i 与 j（i <= j，且从 0 位开始计算）。

编写一种方法，使 M 对应的二进制数字插入 N 对应的二进制数字的第 i ~ j 位区域，不足之处用 0 补齐。具体插入过程如图所示。



题目保证从 i 位到 j 位足以容纳 M， 例如： M = 10011，则 i～j 区域至少可容纳 5 位。

 

示例1:

 输入：N = 1024(10000000000), M = 19(10011), i = 2, j = 6
 输出：N = 1100(10001001100)
示例2:

 输入： N = 0, M = 31(11111), i = 0, j = 4
 输出：N = 31(11111)

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/insert-into-bits-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class I0501_InsertIntoBits {
    ///////////
    //思路：
    //  用位运算
    //  先造掩码
    //  做成j-i为1， j之后为0 （1111000）
    //  掩码用||把M的j-i覆盖为1
    //  n向左移i位, 用循环让1补位
    //  n用&和m合.
    ////////////////

    public int insertBitsA(int N, int M, int i, int j) {
        // 将N中的i~j位清零
        for(int k=i; k<=j; k++) {
            N &= ~(1 << k);
        }
        // 将M左移i位，然后与N进行或运算
        M <<= i;
        return N | M;
    }

    public int insertBitsB(int N, int M, int i, int j) {
        int mask = ((1 << (j - i + 1)) - 1) << i; // 构造掩码
        N &= ~mask; // 清零 i～j 位
        N |= (M << i) & mask; // 将 M 插入 i～j 位
        return N;
    }
}
