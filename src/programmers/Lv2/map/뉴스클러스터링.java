package programmers.Lv2.map;

import java.util.*;

// [1차] 뉴스 클러스터링, Programmers(Level 2, 2018 KAKAO BLIND RECRUITMENT)
public class 뉴스클러스터링 {
    public int solution(String str1, String str2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            String subStr = str1.substring(i, i+2).toLowerCase();
            int sub1 = subStr.charAt(0) - 'a';
            int sub2 = subStr.charAt(1) - 'a';
            if (sub1 >= 0 && sub1 < 26 && sub2 >=0 && sub2 < 26) {
                map1.put(subStr, map1.getOrDefault(subStr, 0) + 1);
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            String subStr = str2.substring(i, i+2).toLowerCase();
            int sub1 = subStr.charAt(0) - 'a';
            int sub2 = subStr.charAt(1) - 'a';
            if (sub1 >= 0 && sub1 < 26 && sub2 >=0 && sub2 < 26) {
                map2.put(subStr, map2.getOrDefault(subStr, 0) + 1);
            }
        }

        int inter = 0;
        int union = 0;

        for (String key1 : map1.keySet()) {
            if (map2.containsKey(key1)) {
                // 두 맵에 공통으로 있는 키면 교집합과 합집합 계산
                int minCount = Math.min(map1.get(key1), map2.get(key1));
                int maxCount = Math.max(map1.get(key1), map2.get(key1));
                inter += minCount;
                union += maxCount;
            } else {
                // map1에만 있는 경우 합집합에 추가
                union += map1.get(key1);
            }
        }

        // map2에만 남아있는 요소들 합집합에 추가
        for (String key2 : map2.keySet()) {
            if (!map1.containsKey(key2)) {
                union += map2.get(key2);
            }
        }

        int answer = union == 0 ? 65536 : (int) (((double) inter / union) * 65536);
        return answer;
    }
}
