package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// c
public class 바이러스 {
    static int[][] graph;
    static boolean[] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());    // 컴퓨터의 수
        M = Integer.parseInt(br.readLine());    // 컴퓨터의 쌍의 수
        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        bfs(1);
    }
    public static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();

        visited[x] = true;
        queue.add(x);
        int count = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 1; i < N + 1; i++) {
                if (graph[now][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    count++;

                }
            }
        }
        System.out.println(count);
    }
}
