package programmers.Lv2.map;

import java.util.*;

// 할인 행사, Programmers(Level 2)
public class 할인행사 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> discountMap = new HashMap<>();

            for (int j = 0; j < 10; j++) {
                discountMap.put(discount[i + j], discountMap.getOrDefault(discount[i + j], 0) + 1);
            }

            boolean isEquals = true;

            for (String s : map.keySet()) {
                if (map.get(s) != discountMap.get(s)) {
                    isEquals = false;
                    break;
                }
            }
            if (isEquals) {
                answer++;
            }
        }
        return answer;
    }
}
