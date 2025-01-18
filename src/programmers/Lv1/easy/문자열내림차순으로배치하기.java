package programmers.Lv1.easy;

import java.util.Arrays;
import java.util.Collections;

// 문자열 내림차순으로 배치하기, Programmers(Level 1)
public class 문자열내림차순으로배치하기 {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split("");

        Arrays.sort(str, Collections.reverseOrder());

        for (String ch : str) {
            answer += ch;
        }

        return answer;
    }
}
