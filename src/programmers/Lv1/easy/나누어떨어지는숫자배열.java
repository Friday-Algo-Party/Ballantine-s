package programmers.Lv1.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 나누어 떨어지는 숫자 배열, Programmers(Level 1)
public class 나누어떨어지는숫자배열 {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                list.add(arr[i]);
            }
        }

        Collections.sort(list);

        if (list.size() == 0) {
            list.add(-1);
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
