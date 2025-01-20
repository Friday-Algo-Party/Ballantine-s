package programmers.Lv1.easy;

// 문자열 다루기 기본, Programmers(Level 1)
public class 문자열다루기기본 {
    public boolean solution(String s) {
        boolean answer = true;

        if (s.length() == 4 || s.length() == 6) {
            for (int i = 0; i < s.length(); i++) {
                if (!Character.isDigit(s.charAt(i))) {
                    answer = false;
                    break;
                }
            }
        } else {
            answer = false;
        }
        return answer;
    }
//    // 다른 풀이
//    public boolean solution(String s) {
//        if (s.length() == 4 || s.length() == 6) {
//            try {
//                Integer.parseInt(s);
//                return true;
//            } catch (NumberFormatException e) {
//                return false;
//            }
//        } else {
//            return false;
//        }
//    }
}
