package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 피보나치 함수(dp), 실버 III
public class 피보나치함수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[] zero = new int[41];
        int[] one = new int[41];

        for (int testCase = 0; testCase < T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            zero[0] = 1;
            one[0] = 0;
            zero[1] = 0;
            one[1] = 1;

            for (int i = 2; i <= N; i++) {
                zero[i] = zero[i - 1] + zero[i - 2];
                one[i] = one[i - 1] + one[i - 2];
            }

            System.out.println(zero[N] + " " + one[N]);
        }
    }
}
