package programmers.Lv1.easy;

// 문자열 내 p와 y의 개수, Programmers(Level 1)
public class 문자열내p와y의개수 {
    boolean solution(String s) {
        boolean answer = true;
        String str = s.toLowerCase();

        int cntP = 0, cntY = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'p') {
                cntP++;
            } else if (c == 'y') {
                cntY++;
            }
        }
        if (cntP != cntY) {
            answer = false;
        }
        return answer;
    }
}
