package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 달팽이는 올라가고 싶다(Math), 브론즈 1
public class 달팽이는올라가고싶다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int day;

        if (A == V) {
            day = 1;
        } else if ((V - A) % (A - B) == 0) {
            day = (V - A) / (A - B) + 1;
        } else {
            day = (V - A) / (A - B) + 2;
        }

        System.out.println(day);
    }
}
