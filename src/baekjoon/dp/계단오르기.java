package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 계단 오르기(dp), 실버 III
public class 계단오르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stairs = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(stairs[0]);
            return;
        }

        dp[0] = stairs[0];
        dp[1] = stairs[0] + stairs[1];

        if (n > 2) {
            dp[2] = Math.max(stairs[0] + stairs[2], stairs[1] + stairs[2]);
        }

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + stairs[i], dp[i - 3] + stairs[i - 1] + stairs[i]);
        }

        System.out.println(dp[n - 1]);
    }
}
