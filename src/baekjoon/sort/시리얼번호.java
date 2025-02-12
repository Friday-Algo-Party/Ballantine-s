package baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// 시리얼번호(sort), 실버 III
public class 시리얼번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    int o1Cnt = 0;
                    int o2Cnt = 0;
                    for (int i = 0; i < o1.length(); i++) {
                        if (Character.isDigit(o1.charAt(i))) {
                            o1Cnt += o1.charAt(i) - '0';
                        }
                        if (Character.isDigit(o2.charAt(i))) {
                            o2Cnt += Character.getNumericValue(o2.charAt(i));
                        }
                    }
                    if (o1Cnt == o2Cnt) {
                        return o1.compareTo(o2);
                    }
                    return o1Cnt - o2Cnt;
                }
                return Integer.compare(o1.length(), o2.length());
            }
        });

        for (String s : arr) {
            sb.append(s).append("\n");
        }

        System.out.print(sb);
    }
}
