package baekjoon.backtracking;

import java.util.Scanner;

// N과 M (2)(backtracking), 실버 III
public class N과M_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[M];

        // 초기화: 첫 번째 조합을 설정
        for (int i = 0; i < M; i++) {
            arr[i] = i + 1;
        }

        while (true) {
            // 현재 조합 출력
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();

            // 다음 조합 생성
            int index = M - 1;
            while (index >= 0 && arr[index] == N - M + 1 + index) {
                index--;
            }

            // 모든 조합을 다 생성했으면 종료
            if (index < 0) break;

            arr[index]++;

            // 증가된 인덱스 이후의 값들을 조정
            for (int i = index + 1; i < M; i++) {
                arr[i] = arr[i - 1] + 1;
            }
        }
    }
}
