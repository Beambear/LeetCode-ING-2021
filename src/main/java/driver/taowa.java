package driver;

import java.util.Scanner;

public class taowa {
    public void taoWa() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            c[i] = scanner.nextInt();
        }

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
        System.out.println(minCost);
    }
}
