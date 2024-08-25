package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// N-Queen(backtracking), 골드 IV
public class N_Queen {
    static int N;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[][] chess = new int[N][N];

        // 첫 번째 열에 대해 모든 행에서 시작할 수 있도록 함
        dfs(chess, 0);

        System.out.println(count);
    }

    public static void dfs(int[][] chess, int col) {
        if (col == N) {
            count++;
            return;
        }

        for (int row = 0; row < N; row++) {
            if (check(chess, row, col)) {
                chess[row][col] = 1;
                dfs(chess, col + 1);
                chess[row][col] = 0;
            }
        }
    }

    static boolean check(int[][] chess, int row, int col) {
        // 행(가로) 중복 체크
        for (int i = 0; i < col; i++) {
            if (chess[row][i] == 1) return false;
        }

        // \ 방향 체크 (왼쪽 대각선 위)
        for (int i = 1; i <= col; i++) {
            if (row - i >= 0 && col - i >= 0) {
                if (chess[row - i][col - i] == 1) {
                    return false;
                }
            }
        }

        // / 방향 체크 (오른쪽 대각선 위)
        for (int i = 1; i <= col; i++) {
            if (row + i < N && col - i >= 0) {
                if (chess[row + i][col - i] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
