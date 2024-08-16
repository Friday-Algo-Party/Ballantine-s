package baekjoon.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 부분합(two_pointer), 골드 IV
public class 부분합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int i = 0;
        int j = 0;
        int sum = arr[i];
        int len = Integer.MAX_VALUE;

        while (i <= j) {
            if (i >= N || j >= N) {
                break;
            }
//            for (int k = i; k <= j; k++) {
//                sum += arr[k];     // i부터 j까지 수열 합 구하기 -> 시간 초과 남
//            }
            if (sum < S) {         // 합이 목표 S보다 작다면
                j++;               // 포인터 j 위치 증가

                sum += arr[j];     // j 이동한 만큼 합에 더해주기
            } else if (sum >= S) { // 합이 목표 S와 같거나 크다면
                len = Math.min(len, j - i + 1);   // 최소 길이 저장
                sum -= arr[i];     // 포인터 i 이동하기 전에 i번째 값 합에서 빼주기
                i++;               // 포인터 i 위치 증가
            }
        }

        if (len == Integer.MAX_VALUE) {
            System.out.println("0");
        } else {
            System.out.println(len);
        }
    }
}
