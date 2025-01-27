package baekjoon.dac;

import java.io.*;
import java.util.*;

// 곱셈(divide and conquer), 골드 V
public class 곱셈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(pow(A, B, C));
    }

    static long pow(int a, int b, int mod) {
        if (b == 0) {
            return 1;
        }
        long n = pow(a, b / 2, mod);
        long temp = n * n % mod;

        if (b % 2 == 0) {
            return temp;
        } else {
            return temp * a % mod;
        }
    }
}
