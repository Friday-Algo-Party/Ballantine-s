package baekjoon.backtracking;

import java.io.*;
import java.util.*;

// N과 M (9)(backtracking), 실버 II
public class N과M_9 {
    public static int[] arr;
    public static int N, M;
    public static boolean[] visited;
    public static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];
        result = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        backTracking(0);
    }

    public static void backTracking(int depth) {
        if (depth == M) {
            for (int val : result) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        int prev = -1;

        for (int i = 0; i < N; i++) {
            if (!visited[i] && prev != arr[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                prev = arr[i];
                backTracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}
