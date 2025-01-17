package programmers.Lv1.easy;

// 핸드폰 번호 가리기, Programmers(Level 1)
public class 핸드폰번호가리기 {
    public String solution(String phone_number) {
        String answer = "";

        int len = phone_number.length();
        answer = "*".repeat(len - 4) + phone_number.substring(len - 4);

        return answer;
    }
}
