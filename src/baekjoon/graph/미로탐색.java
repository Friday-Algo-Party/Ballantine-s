package baekjoon.graph;햣

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 미로 탐색(graph), 실버 I
public class 미로탐색 {
    static int[] dx = {-1, 1, 0, 0};    // 위, 아래, 왼쪽, 오른쪽 순
    static int[] dy = {0, 0, -1, 1};
    static int[][] maze;
    static boolean[][] visited;         // 방문 배열
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = input.charAt(j) - '0';     // 문자를 int 값으로 변환
            }
        }

        visited[0][0] = true;   // 시작 노드 방문처리
        bfs(0, 0);
        System.out.println(maze[N - 1][M - 1]);         // 최종 목적지 값 출력
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();        // int 배열을 가지는 큐 생성
        queue.add(new int[]{x, y});                     // 길이가 2인 1차원 배열을 큐에 넣어줌 (시작 지점)

        while (!queue.isEmpty()) {
            int now[] = queue.poll();
            int nowX = now[0];                          // 큐에서 꺼낸 배열의 x값
            int nowY = now[1];                          // 큐에서 꺼낸 배열의 y값

            for (int k = 0; k < 4; k++) {               // 위, 아래, 왼쪽, 오른쪽 순으로 탐색을 진행 할 예정
                int nextX = nowX + dx[k];               // 다음 x값
                int nextY = nowY + dy[k];               // 다음 y값

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {       // 다음 x, y가 maze 크기 안에 있어야함
                    if (maze[nextX][nextY] == 1 && !visited[nextX][nextY]) {    // 다음 x, y 이동할 수 있는 1이어야하고 방문하지 X
                        queue.add(new int[]{nextX, nextY});                     // 그렇다면 그 {x, y}를 큐에 넣어줌
                        visited[nextX][nextY] = true;                           // 방문처리 해줌
                        maze[nextX][nextY] = maze[nowX][nowY] + 1;              // 다음 위치 = 현재 위치 값 + 1
                    }
                }
            }
        }
    }
}
