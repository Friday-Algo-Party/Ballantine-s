package programmers.Lv2.dp;

// 멀리 뛰기, Programmers(Level 2)
public class 멀리뛰기 {
    public long solution(int n) {

        long[] dp = new long[n + 2];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }
        return dp[n];
    }
}
