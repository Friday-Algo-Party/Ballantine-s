package baekjoon.sort;

import java.io.*;
import java.util.*;

// 좌표 압축(sort), 실버 II
public class 좌표압축 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sortArr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sortArr[i] = arr[i];
        }

        Arrays.sort(sortArr);

        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for (int i = 0; i < N; i++) {
            if (!map.containsKey(sortArr[i])) {
                map.put(sortArr[i], index++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int value = map.get(arr[i]);
            sb.append(value).append(" ");
        }

        System.out.println(sb);
    }
}
