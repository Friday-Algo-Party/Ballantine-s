package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 웰컴 키트(math), 브론즈III
public class 웰컴키트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 참가자 수

        int[] size = new int[6];  // 사이즈 별 신청자 수 담을 배열
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size.length; i++) {
            size[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());   // 티셔츠 묶음 판매 개수
        int P = Integer.parseInt(st.nextToken());   // 펜 묶음 개수

        int t_count = 0;               // 티셔츠 묶음 저장 변수
        for (int i : size) {
            if (i % T == 0) {          // 티셔츠 묶음으로 나누어 떨어진다면
                t_count += i / T;      // 몪을 티셔츠 묶음 저장 변수에 저장
            } else {
                t_count += i / T + 1;  // 나누어떨어지지 않으면 넉넉하게 1묶음 더 추가
            }
        }

        int pen_bundle = N / P;     // 펜 묶음 저장 변수
        int pen_each = N % P;       // 펜 낱개 저장 변수

        System.out.println(t_count);
        System.out.println(pen_bundle + " " + pen_each);
    }
}
