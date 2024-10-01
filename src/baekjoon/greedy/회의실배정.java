package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 회의실 배정(greedy), 실버 I
public class 회의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] meeting = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meeting[i][0] = Integer.parseInt(st.nextToken());
            meeting[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meeting, (o1, o2) -> {
            if (o1[1] == o2[1]) {       // 두번째 수가 같다면
                return o1[0] - o2[0];   // 첫번째 오름차순
            }
            return o1[1] - o2[1];       // 기본은 두번째 수 오름차순 정렬
        });

        int meetingEnd = 0;
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (meetingEnd <= meeting[i][0]) {
                meetingEnd = meeting[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
