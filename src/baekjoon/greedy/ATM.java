package baekjoon.greedy;

import java.io.*;
import java.util.*;

// ATM(greedy), 실버 IV
public class ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);   // 오름차순 정렬하기

        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                result += arr[j];
            }
        }
        System.out.println(result);
    }
}
