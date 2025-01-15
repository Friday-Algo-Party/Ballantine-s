package programmers.Lv1.easy;

// 서울에서 김서방 찾기, Programmers(Level 1)
public class 서울에서김서방찾기 {
    public String solution(String[] seoul) {
        String answer = "";

        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                answer += "김서방은 " + i + "에 있다";
            }
        }
        return answer;
    }
}
// if 조건문에서 break를 하면 더 효율적일 수 있음