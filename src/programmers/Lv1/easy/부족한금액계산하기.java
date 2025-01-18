package programmers.Lv1.easy;

// 부족한 금액 계산하기, Programmers(Level 1)
public class 부족한금액계산하기 {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long sum = 0;
        int cnt = 1;

        for (int i = 0; i < count; i++) {
            sum += price * cnt;
            cnt++;
        }

        answer = sum - money;

        if (answer <= 0) {
            answer = 0;
        }
        return answer;
    }
//    // 다른 사람의 풀이
//    public long solution(int price, int money, int count) {
//        long answer = 0;
//        for (int i = 1; i <= count; i++) {
//            answer += price * i;
//        }
//        return Math.max(answer - money, 0);
//    }
}
