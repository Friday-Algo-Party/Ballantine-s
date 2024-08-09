package baekjoon.greedy;

import java.io.*;

// 설탕 배달(greedy), 실버 IV
public class 설탕배달 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;  // 봉지 사용 개수 저장 변수

        while (true) {
            if (N % 5 == 0) {   // 5로 나누는 것이 효율이 가장 좋음 5로 나눠지는지 먼저 확인
                int sugar = N / 5;
                System.out.println(sugar + count);
                break;
            } else if (N < 0) {
                System.out.println("-1");
                break;
            } else {
                N -= 3;     // 5로 안나눠지고 아직 0보다 안작을 때 3키로 봉지에 넣는다고 생각
                count++;    // 봉투 하나 쓴거로 판단
            }
        }
    }
}
