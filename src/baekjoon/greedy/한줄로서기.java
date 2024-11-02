package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 한 줄로 서기(greedy), 실버 II
public class 한줄로서기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] answer = new int[N + 1];


        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            int j = 1;

            while (true) {
                if (arr[i] == 0 && answer[j] == 0) {
                    answer[j] = i;
                    break;
                } else if (answer[j] == 0) {
                    arr[i]--;
                }
                j++;
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}
