package programmers.Lv1.easy;

// 콜라츠 추측, Programmers(Level 1)
public class 콜라츠추측 {
    public int solution(int num) {
        int count = 0;
        long number = num;

        if (number == 1) {
            return count;
        }

        while (count <= 500) {
            if (count == 500) {
                count = -1;
                break;
            }
            if (number == 1) {
                break;
            }
            if (number % 2 == 0) {
                number /= 2;
                count++;
            } else {
                number = number * 3 + 1;
                count++;
            }
        }
        return count;
    }
}
// 다른 사람의 풀이
//    public int solution(int num) {
//        int answer = 0;
//        long number = num;
//
//        while (number != 1) {
//            if (number % 2 == 0) {
//                number /= 2;
//            } else {
//                number = number * 3 + 1;
//            }
//            answer++;
//
//            if (answer == 500) {
//                return -1;
//            }
//        }
//        return answer;
//    }

