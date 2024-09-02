package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 평범한 배낭(dp), 골드 V
public class 평범한배낭 {

    static int W;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 물품의 수
        int K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게
        int[] dp = new int[K + 1];                // dp에 저장할 배열

        int[] weights = new int[N];
        int[] values = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());   // 각 물건의 무게
            values[i] = Integer.parseInt(st.nextToken());    // 그 물건의 가치
        }

        // DP 배열을 갱신
        for (int i = 0; i < N; i++) {
            for (int j = K; j >= weights[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
            }
        }

        System.out.println(dp[K]);
    }
}
