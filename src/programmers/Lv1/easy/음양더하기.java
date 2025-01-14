package programmers.Lv1.easy;

// 음양 더하기, Programmers(Level 1)
public class 음양더하기 {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0; i < signs.length; i++) {
            if (!signs[i]) {
                answer += (absolutes[i] * -1);
            } else {
                answer += absolutes[i];
            }
        }
        return answer;
    }
}
