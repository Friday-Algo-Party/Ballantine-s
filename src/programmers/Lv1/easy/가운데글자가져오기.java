package programmers.Lv1.easy;

// 가운데 글자 가져오기, Programmers(Level 1)
public class 가운데글자가져오기 {
    public String solution(String s) {
        String answer = "";
        int mid = s.length() / 2;

        if (s.length() % 2 == 0) {
            answer = s.charAt(mid - 1) + "" + s.charAt(mid);
        } else {
            answer += s.charAt(mid);
        }
        return answer;
    }
}
