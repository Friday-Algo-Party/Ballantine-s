package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 유기농 배추(graph), 실버 II
public class 유기농배추 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int M, N, K;
    static int[][] cabbage;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < T; testCase++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());       // 가로
            N = Integer.parseInt(st.nextToken());       // 세로
            K = Integer.parseInt(st.nextToken());       // 배추 개수

            cabbage = new int[N][M];
            count = 0;                                  // 배추흰지렁이 개수

            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                cabbage[y][x] = 1;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (cabbage[i][j] == 1) {
                        count++;
                        bfs(i, j);
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        cabbage[x][y] = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int k = 0; k < 4; k++) {
                int nextX = nowX + dx[k];
                int nextY = nowY + dy[k];

                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
                    if (cabbage[nextX][nextY] == 1) {
                        queue.offer(new int[]{nextX, nextY});
                        cabbage[nextX][nextY] = 0;
                    }
                }
            }
        }
    }
}
