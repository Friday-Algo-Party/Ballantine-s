package baekjoon.graph;

import java.io.*;
import java.util.*;

// 숨바꼭질 3(graph), 골드 V
public class 숨바꼭질3 {
    static int N;
    static int K;
    static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
        } else {
            bfs(N, K);
        }
    }

    static void bfs(int N, int K) {
        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(visited, -1);
        queue.add(N);
        visited[N] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now * 2 <= 100000 && visited[now * 2] == -1) {
                visited[now * 2] = visited[now];
                queue.add(now * 2);
            }

            if (now - 1 >= 0 && visited[now - 1] == -1) {
                visited[now - 1] = visited[now] + 1;
                queue.add(now - 1);
            }

            if (now + 1 <= 100000 && visited[now + 1] == -1) {
                visited[now + 1] = visited[now] + 1;
                queue.add(now + 1);
            }
        }
        System.out.println(visited[K]);
    }
}
