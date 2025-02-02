package baekjoon.graph;

import java.io.*;
import java.util.*;

// 연결 요소의 개수(graph), 실버 II
public class 연결요소의개수 {
    static int N;
    static int M;
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        bfs();
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                queue.add(i);
                visited[i] = true;
                count++;
            }

            while (!queue.isEmpty()) {
                int now = queue.poll();

                for (int j = 1; j <= N; j++) {
                    if (graph[now][j] == 1 && !visited[j]) {
                        queue.add(j);
                        visited[j] = true;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
