package programmers.Lv1.easy;

import java.util.Arrays;
import java.util.Collections;

// 정수 내림차순으로 배치하기, Programmers(Level 1)
public class 정수내림차순으로배치하기 {
    public long solution(long n) {
        long answer = 0;
        String[] str = Long.toString(n).split("");
        Arrays.sort(str, Collections.reverseOrder());

        String num = "";
        for (String s : str) {
            num += s;
        }
        answer = Long.parseLong(num);
        return answer;
    }
}
