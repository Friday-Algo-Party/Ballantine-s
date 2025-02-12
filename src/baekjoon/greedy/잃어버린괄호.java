package baekjoon.greedy;

import java.io.*;

// 잃어버린 괄호(greedy), 실버 II
public class 잃어버린괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("-");

        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];

            if (i == 0) {
                String[] firstStr = str.split("\\+");
                for (int j = 0; j < firstStr.length; j++) {
                    answer += Integer.parseInt(firstStr[j]);
                }
            } else {
                String[] nextStr = str.split("\\+");
                for (int j = 0; j < nextStr.length; j++) {
                    answer -= Integer.parseInt(nextStr[j]);
                }
            }

        }
        System.out.println(answer);
    }
}
