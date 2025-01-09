package programmers.Lv1.easy;

// 정수 제곱근 판별, Programmers(Level 1)
public class 정수제곱근판별 {
    public long solution(long n) {
        long answer = -1;

        for (long i = 0; i <= n; i++) {
            if (i * i == n) {
                return (i + 1) * (i + 1);
            }
        }
        return answer;
    }
}
