package baekjoon.bronze;

import java.io.*;
import java.util.*;

// 평균(math), 브론즈I
public class 평균 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        double[] arr = new double[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);   // 정렬
        double max = arr[N - 1];    // 최댓값

        double num = 0;
        for (double v : arr) {
            num += v / max * 100;
        }

        double result = num / N;
        System.out.println(result);
    }
}
