package programmers.Lv1.easy;

// 두 정수 사이의 합, Programmers(Level 1)
public class 두정수사이의합 {
    public long solution(int a, int b) {
        long answer = 0;
        int min = Math.min(a, b);
        int max = Math.max(a, b);

        for (int i = min; i <= max; i++){
            answer += i;
        }
        return answer;
    }
}
