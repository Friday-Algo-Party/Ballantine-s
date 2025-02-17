package baekjoon.dp;

import java.io.*;

// 2xn 타일링 2(dp), 실버 III
public class 이xn타일링2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];

        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = (dp[i - 1] * 2 + 1) % 10007;
            } else {
                dp[i] = (dp[i - 1] * 2 - 1) % 10007;
            }
        }
        System.out.println(dp[n]);
    }
}
