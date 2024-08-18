package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 정수 삼각형(dp), 실버 II
public class 정수삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = arr[0][0];   // 최상위 값 초기화

        // dp 배열 메모이제이션
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {                                   // 맨 왼쪽에 위치한 수
                    dp[i][j] = dp[i-1][j] + arr[i][j];          // 내 위에 있는 위치의 dp 배열 값과 현재 자신의 수를 더함
                } else if (j == i) {                            // 맨 오른쪽에 위치한 수
                    dp[i][j] = dp[i - 1][j - 1] + arr[i][j];    // 내 왼쪽 위에 있는 위치의 dp 배열 값과 현재 자신의 수를 더함
                } else {                                        // 중간에 위치한 수들
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + arr[i][j]; // 위쪽 또는 왼쪽 위와 중에 큰값 선택
                }
            }
        }

        // 메모이제이션 완료된 dp 배열 맨 아래쪽 값중 가장 큰 값 선택
        int max = 0;
        for (int j = 0; j < n; j++) {
            max = Math.max(max, dp[n-1][j]);
        }
        System.out.println(max);
    }
}
