package programmers.Lv2.brute_force;

import java.util.*;

// 연속 부분 수열 합의 개수, Programmers(Level 2)
public class 연속부분수열합의개수 {
    public int solution(int[] elements) {
        int[] sumArr = new int[elements.length * 2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < elements.length; i++) {
            sumArr[i] = sumArr[i + elements.length] = elements[i];
        }

        for (int i = 0; i < elements.length; i++) {
            int sum = 0;
            for (int j = i; j < i + elements.length; j++) {
                sum += sumArr[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        return map.size();
    }
}
