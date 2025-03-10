package baekjoon.dp;

import java.io.*;

// 파도반 수열(dp), 실버 III
public class 파도반수열 {
    static long[] arr = new long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        padovan();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            sb.append(arr[Integer.parseInt(br.readLine())]).append('\n');
        }
        System.out.println(sb);
    }

    public static void padovan() {

        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;

        for (int i = 4; i < 101; i++) {
            arr[i] = arr[i - 2] + arr[i - 3];
        }
    }
}
