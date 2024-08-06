package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// RGB거리(dp), 실버I
public class RGB거리 {
    static int[][] dp;
    static int[][] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        cost = new int[N][3];
        dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        System.out.println(Math.min(paint(N - 1, 0), Math.min(paint(N - 1, 1), paint(N - 1, 2))));
    }

    public static int paint(int n, int color) {
        if (dp[n][color] == 0) {       // dp 값이 아직 초기화되지 않았으면
            if (color == 0) {      // 빨강을 칠했으면
                dp[n][0] = Math.min(paint(n - 1, 1), paint(n - 1, 2)) + cost[n][0];
            }
            if (color == 1) {      // 초록을 칠했으면
                dp[n][1] = Math.min(paint(n - 1, 0), paint(n - 1, 2)) + cost[n][1];
            }
            if (color == 2) {      // 파랑을 칠했으면
                dp[n][2] = Math.min(paint(n - 1, 0), paint(n - 1, 1)) + cost[n][2];
            }
        }
        return dp[n][color];
    }
}
