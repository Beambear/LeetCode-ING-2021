package practice;
/*
在一个 n x n 的国际象棋棋盘上，一个骑士从单元格 (row, column) 开始，
并尝试进行 k 次移动。行和列是 从 0 开始 的，
所以左上单元格是 (0,0) ，右下单元格是 (n - 1, n - 1) 。

象棋骑士有8种可能的走法，如下图所示。每次移动在基本方向上是两个单元格，然后在正交方向上是一个单元格。

每次骑士要移动时，它都会随机从8种可能的移动中选择一种(即使棋子会离开棋盘)，然后移动到那里。

骑士继续移动，直到它走了 k 步或离开了棋盘。

返回 骑士在棋盘停止移动后仍留在棋盘上的概率 。

 

示例 1：

输入: n = 3, k = 2, row = 0, column = 0
输出: 0.0625
解释: 有两步(到(1,2)，(2,1))可以让骑士留在棋盘上。
在每一个位置上，也有两种移动可以让骑士留在棋盘上。
骑士留在棋盘上的总概率是0.0625。
示例 2：

输入: n = 1, k = 0, row = 0, column = 0
输出: 1.00000

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/knight-probability-in-chessboard
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P688_KnightProbabilityInChessboard {

    /////////////////
    //思路：
    //  走0步一定在棋盘上， p=1
    //  骑士第一步有8种可能性，成功为1/8, 失败为0/8. 所有可能性加起来则是最终可能性。 p = ? /8
    //      F: 失败的没有第二步，不再遍历, 0/8 记进总结果。
    //      S: 成功的有下一步， 1/8 不计入总结果，需要拆成8份继续遍历知道走完k步或者走出棋盘。
    //
    //  走第二部的时候 1/8 中的 '1' 可再分为8种可能性， 每份又为 (1/8)/8 或 (0/8)/8.
    //      即总成功率 P = ? /64.
    //  一直循环至走完k步
    //
    //  8个方向记录为数组，direction={ (+2,+1), (+2,-1), (-2,+1), (-2,-1), (+1,+2),(-1,+2),(+1,-2),(-1,-2)}
    //  停止条件k=0
    //////////////
    public double knightProbability(int n, int k, int row, int column) {
        double p=0;
        double[][][] chessboard = new double[k+1][n][n];  //棋谱 = 一个有k层，n*n大小的棋盘
        chessboard[k][row][column] = 1; //initial knight
        int[][] dirs = { {2,1},{2,-1},{-2,1},{-2,-1},{1,2},{-1,2},{1,-2},{-1,-2}};
        while(k!=0){    //k = 剩余步数
            for(int i=0; i<n;i++){
                for(int j=0;j<n;j++){   //遍历整个棋盘
                    if(chessboard[k][i][j] != 0 ){  //棋子可能出现在这里
                        double curP = chessboard[k][i][j];  //Posibility at this point
                        for(int[] dir:dirs){    //试探所有方向
                            int rNew = i + dir[0];
                            int cNew = j + dir[1];
                            if(rNew >= 0 && rNew < n && cNew >=0 && cNew < n){  //下一步在棋盘里
                                chessboard[k-1][rNew][cNew] += curP/8;  //新一层该点位概率加1/8当前
                            }
                        }
                    }
                }
            }
            k--;
        }
        // 走完k步
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                p+= chessboard[0][i][j];    //k=0时的全棋盘概率相加
            }
        }
        return p;
    }
}
