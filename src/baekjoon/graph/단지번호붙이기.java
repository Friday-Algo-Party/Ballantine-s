package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 단지번호붙이기(graph), 실버 I
public class 단지번호붙이기 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;
    static int[][] map;
    static int size;
    static List<Integer> houseCnt = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    size = 0;
                    bfs(i, j);
                    houseCnt.add(size);
                }
            }
        }
        Collections.sort(houseCnt);

        System.out.println(houseCnt.size());
        for (Integer integer : houseCnt) {
            System.out.println(integer);
        }
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        map[x][y] = 0;
        size++;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int k = 0; k < 4; k++) {
                int nextX = nowX + dx[k];
                int nextY = nowY + dy[k];

                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N) {
                    if (map[nextX][nextY] == 1) {
                        queue.add(new int[]{nextX, nextY});
                        map[nextX][nextY] = 0;
                        size++;
                    }
                }
            }
        }
    }
}
