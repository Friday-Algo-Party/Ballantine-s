package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 벌집(math), 브론즈 II
public class 벌집 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int increase = 6;           // 증가 변수
        int num = 1;                // 현재 num
        int count = 1;              // 지나가는 방 수

        while (N > num) {
            num += increase;
            increase += 6;
            count++;
        }
        System.out.println(count);
    }
}
