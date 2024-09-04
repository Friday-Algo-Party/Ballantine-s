package baekjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 피보나치 함수(dp), 실버 III -> 시간초과
public class 피보나치함수실패 {

    static int zero;
    static int one;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < T; testCase++) {
            int N = Integer.parseInt(br.readLine());
            zero = 0;
            one = 0;

            fibonacci(N);

            System.out.println(zero + " " + one);
        }
    }

    public static void fibonacci(int n) {
        if (n == 0) {
            zero++;
        } else if (n == 1) {
            one++;
        } else {
            fibonacci(n - 1);
            fibonacci(n - 2);
        }
    }
}
