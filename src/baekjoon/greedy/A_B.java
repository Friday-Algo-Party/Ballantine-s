package baekjoon.greedy;

import java.io.*;
import java.util.*;

// A -> B(greedy), 실버 II
public class A_B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());

        int result = 1;
        while (B > A) {
            if (B % 2 == 0) {
                B /= 2;
            } else if (B % 10 == 1) {
                B /= 10;
            } else {
                break;
            }
            result++;
        }

        if (A == B) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }
}
