package practice;

import java.util.ArrayList;
import java.util.List;

/*
Alice and Bob continue their games with piles of stones.  There are a number of piles arranged in a row, and each pile has a positive integer number of stones piles[i].  The objective of the game is to end with the most stones. 

Alice and Bob take turns, with Alice starting first.  Initially, M = 1.

On each player's turn, that player can take all the stones in the first X remaining piles, where 1 <= X <= 2M.  Then, we set M = max(M, X).

The game continues until all the stones have been taken.

Assuming Alice and Bob play optimally, return the maximum number of stones Alice can get.

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/stone-game-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P1140_StoneGameII {
    /////////
    //思路：
    // 要点 可选范围 x =[1~2M]
    // M = max (M,X)
    //
    //
    //
    //
    //
    ////////////
    public int stoneGameII(int[] piles){
        int alexSum =0;
        int bobSum =0;
        int m=1;
    }
    private int nextAlexMove(int[] piles, int m, int index, int sumA, int sumB, boolean alexTurn){
        List<Integer> alexSums = new ArrayList<>();
        List<Integer> bobSums = new ArrayList<>();
        int end = Math.min(index+2*m, piles.length);
        int curSum =0;
        for(int i = index; i<end;i++){
            curSum += piles[i]; //当前能拿的石头
            int curM = Math.max(m,i-index+1);

            if(alexTurn){//这回合是alex，下回合是bob
                int futureSum = nextAlexMove(piles,curM,i+1,sumA+curSum,sumB,!alexTurn);
                alexSums.add(futureSum+sumA+curSum);
            }else{  //这回合是bob，下回合是alex
                int futureSum = nextAlexMove(piles,curM,i+1,sumA+curSum,sumB,!alexTurn);
            }
        }

    }

    private int nextBobMove(int[] piles, int m, int index, int sumA, int sumB, boolean alexTurn){

        return 0;
    }
}




