package programmers.Lv1.easy;

import java.util.Arrays;

// 없는 숫자 더하기, Programmers(Level 1)
public class 없는숫자더하기 {
    public int solution(int[] numbers) {
        int answer = 45;
        Arrays.sort(numbers);

        for (int number : numbers) {
            answer -= number;
        }
        return answer;
    }
}
