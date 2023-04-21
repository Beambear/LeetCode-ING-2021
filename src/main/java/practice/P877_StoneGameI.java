package practice;
/*
    Alice and Bob play a game with piles of stones. There are an even number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].

The objective of the game is to end with the most stones. The total number of stones across all the piles is odd, so there are no ties.

Alice and Bob take turns, with Alice starting first. Each turn, a player takes the entire pile of stones either from the beginning or from the end of the row. This continues until there are no more piles left, at which point the person with the most stones wins.

Assuming Alice and Bob play optimally, return true if Alice wins the game, or false if Bob wins.

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/stone-game
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P877_StoneGameI {
    ////////
    //思路:
    //  因为是偶数堆石头,
    //  当Alex拿石头时，他可以全拿index为偶数的石头[从头].
    //                  或者他可以全拿index为奇数的石头[从尾].
    //  因为当alex拿了奇数位置后， 头尾都是偶数脚标组。
    //       alex拿了偶数位置后，头尾都是奇数脚标组。
    // 所以当alex拿了奇数后，bob只能拿偶数。
    //  那么只要提前计算所有奇数和偶数脚标的和，哪个更大alex就拿哪组。
    //  alex一定会赢
    /////////
    public boolean stoneGame(int[] piles) {
        return true;
    }
}
