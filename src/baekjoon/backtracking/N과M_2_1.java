package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N과 M (2)(backtracking), 실버 III
public class N과M_2_1 {
    public static int[] arr;
    public static int N, M;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        backTracking(1, 0);
        System.out.println(sb);
    }

    public static void backTracking(int num, int depth) {
        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = num; i <= N; i++) {
            arr[depth] = i;
            backTracking(i + 1, depth + 1);
        }
    }
}
