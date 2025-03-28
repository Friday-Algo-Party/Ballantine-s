package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 토마토-7569번(graph), 골드 V
public class 토마토2 {
    static int N, M, H;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int[][][] tomato;
    static boolean[][][] visited;
    static class Node {
        int x, y, z;

        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        tomato = new int[H][N][M];
        visited = new boolean[H][N][M];
        int count = 0;

        Queue<Node> queue = new LinkedList<>();
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    tomato[h][n][m] = Integer.parseInt(st.nextToken());
                    if (tomato[h][n][m] == 1) {
                        queue.add(new Node(h, n, m));
                    } else if (tomato[h][n][m] == 0) {
                        count++;
                    }
                }
            }
        }
        if (count == 0) {
            System.out.println(0);
            return;
        }
        System.out.println(bfs(queue, count));
    }

    public static int bfs(Queue<Node> queue, int count) {
        int days = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node now = queue.poll();
                for (int j = 0; j < 6; j++) {
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];
                    int nz = now.z + dz[j];
                    if (nx >= 0 && nx < H && ny >= 0 && ny < N && nz >= 0 && nz < M) {
                        if (tomato[nx][ny][nz] == 0 && !visited[nx][ny][nz]) {
                            visited[nx][ny][nz] = true;
                            queue.add(new Node(nx, ny, nz));
                            count--;
                        }
                    }
                }
            }
            days++;
        }
        return count == 0 ? days - 1 : -1;
    }
}
