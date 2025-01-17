package programmers.Lv1.easy;

// 제일 작은 수 제거하기, Programmers(Level 1)
public class 제일작은수제거하기 {
    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }

        int min = arr[0];
        for (int num : arr) {
            if (num < min) {
                min = num;
            }
        }

        int[] answer = new int[arr.length - 1];
        int idx = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == min) {
                continue;
            }
            answer[idx++] = arr[i];
        }

        return answer;
    }
}
