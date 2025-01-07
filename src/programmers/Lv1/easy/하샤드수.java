package programmers.Lv1.easy;

// 하샤드 수, Programmers(Level 1)
public class 하샤드수 {
    public boolean solution(int x) {
        boolean answer = true;
        String number = Integer.toString(x);
        int sum = 0;

        for (int i = 0; i < number.length(); i++) {
            int num = Integer.parseInt(number.substring(i, i + 1));
            sum += num;
        }

        if (x % sum != 0) {
            answer = false;
        }
        return answer;
    }
}
