package programmers.Lv2.DFS_BFS;

import java.util.*;

// 게임 맵 최단거리, Programmers(Level 2)
public class 게임맵최단거리 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    public int solution(int[][] maps) {

        map = maps;
        bfs(map);
        return maps[maps.length - 1][maps[0].length - 1] == 1 ? -1 : maps[maps.length - 1][maps[0].length - 1];
    }

    public void bfs(int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int k = 0; k < 4; k++) {
                int nextX = nowX + dx[k];
                int nextY = nowY + dy[k];

                if (nextX >= 0 && nextX < maps.length && nextY >= 0 && nextY < maps[0].length) {
                    if (maps[nextX][nextY] == 1) {
                        queue.offer(new int[]{nextX, nextY});
                        maps[nextX][nextY] = maps[nowX][nowY] + 1;
                    }
                }
            }
        }
    }
}
