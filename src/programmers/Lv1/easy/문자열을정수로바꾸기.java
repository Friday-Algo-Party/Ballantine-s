package programmers.Lv1.easy;

// 문자열을 정수로 바꾸기, Programmers(Level 1)
public class 문자열을정수로바꾸기 {
    public int solution(String s) {
        int answer = 0;
        String check = s.substring(0, 1);

        if (check.equals("+")) {
            answer = Integer.parseInt(s.substring(1));
        } else {
            answer = Integer.parseInt(s);
        }
        return answer;
    }
}
