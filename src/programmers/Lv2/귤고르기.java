package programmers.Lv2;

import java.util.*;

// 귤 고르기, Programmers(Level 2)
public class 귤고르기 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }

        List<Integer> tangerineValues = new ArrayList<>(map.values());
        Collections.sort(tangerineValues, Collections.reverseOrder());

        int tangerineSum = 0;
        for (int tangerineCnt : tangerineValues) {
            if (tangerineSum + tangerineCnt >= k) {
                answer++;
                break;
            } else {
                tangerineSum += tangerineCnt;
                answer++;
            }
        }
        return answer;
    }
}
