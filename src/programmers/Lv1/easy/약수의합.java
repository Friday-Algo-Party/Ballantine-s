package programmers.Lv1.easy;

// 약수의 합, Programmers(Level 1)
public class 약수의합 {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                answer += i;
            }
        }
        return answer;
    }
}
