package driver;

import google.DriverGoogle;


import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int n=3;
        int[] a = {5,4,3};
        int[] b = {4,2,3};
        int[] c = {3,2,1};
        Main driver = new Main();
//        int res= driver.nestingToy(n,a,b,c);
        String q="Q2R2Q2R3Q2";
        driver.traffic(3,5,q);
    }

    private int findPrefix(String s, String t){
        //////////////////
        //思路：
        //  让s成为t的前缀，查找s最小的修改次数。
        //  修改规则为更改当前字符，或者删除末尾字符。
        //
        //  此规则下，不用考虑删除s开头元素的问题。
        //  那么从s(index= s.length-1)开始向前比较。
        //  如果s.length>t.length, 删除， 计数+1
        //      else s(i) != t(i), 更改， 计数+1
        //      else s(i) == t(i), 不变， 计数+0
        /////////////////////
        int count =0;
        for(int i =s.length()-1;i>=0;i--){   //从s尾部开始
            if(i>t.length()-1){ ///删除，count++
                count++;
            }else if(s.charAt(i)!=t.charAt(i)){ //更改
                count++;
            }
        }
        return count;
    }

    private void shareCandy(int a, int b, int n){
        //////////////////
        //思路：
        //  分糖果，每个人智能拿一种糖，且要尽可能的多拿
        //
        //  轮流给a糖和b糖。
        /////////////////
    }

    private void traffic(int n, int t, String q){
        //////////
        //思路：
        //  两个方法，
        //  1，用LinkedList来做，创建city class， 有city left, city right 和 int val
        //  2.用两个boolean[] 来记录向左向右的可能性
        //////////
        boolean[] toLeft = new boolean[n+1];
        boolean[] toRight = new boolean[n+1];
        int[] res = new int[2];
        //开始修路
        for(int i=0;i<q.length();i++){    //遍历输入语句
            char dir = q.charAt(i); //获取修路方向
            i++;
//            char city = q.charAt(i);//获取起点城市
            int city=Character.getNumericValue(q.charAt(i));
            System.out.println("i:"+i+",order:"+dir+",city:"+city);
            if(dir == 'L'){ //向左修路
                if(city>1){ //最左不能向左修, city-1不存在
                    toLeft[city] = true;
                    toRight[city-1]=true;
                }
            }else if(dir == 'R'){  //向右修路
                if(city<n){ //最右不能向右，city+1不存在
                    toRight[city]=true;
                    toLeft[city+1]=true;
                }
            }else if(dir == 'Q'){//双向查路
                res[0]=1;
                res[1]=n;
                for(int l=city;l>1;l--){
                    if(!toLeft[l]){ //向左到尽头 或者断路
                        res[0]=l;
                        break;
                    }
                }
                for(int r=city;r<n+1;r++){
                    if(!toRight[r]){     //向右到尽头 或者断路
                        res[1]=r;
                        break;
                    }
                }
                System.out.println(res[0]+" "+res[1]);
            }
        }
    }

    private int nestingToy(int n, int[] a,int[] b, int[] c){
        // dp[i] 表示将第 i 个套娃放在所有可能的位置（前 i-1 个套娃中的任何一个）所需的最小花费
        int[] dp = new int[n];
        dp[0] = c[0];
        for (int i = 1; i < n; i++) {
            dp[i] = c[i];
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && b[j] > b[i]) { // 如果套娃 j 能套在套娃 i 里面
                    dp[i] = Math.min(dp[i], dp[j] + c[i]); // 尝试将套娃 i 放在套娃 j 里面，并计算花费
                }
            }
        }

        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minCost = Math.min(minCost, dp[i]);
        }
        System.out.println("minCost:"+minCost);
        return minCost;
    }
}