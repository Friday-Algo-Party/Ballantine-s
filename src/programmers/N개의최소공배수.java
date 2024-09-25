package programmers;

// N개의 최소공배수, Programmers(Level 2)
public class N개의최소공배수 {
    public int solution(int[] arr) {
        int nowLeastNum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int nextNum = arr[i];

            int min = Math.min(nowLeastNum, nextNum);
            for (int j = min; j > 0; j--) {
                if (nowLeastNum % j == 0 && nextNum % j == 0) {
                    nowLeastNum = j * (nowLeastNum / j) * (nextNum / j);
                    break;
                }
            }
        }
        return nowLeastNum;
    }
}
