package programmers.Lv2.map_sort;

import java.util.*;

// 튜플, Programmers(Level 2, 2019 카카오 개발자 겨울 인턴십)
public class 튜플 {
    public int[] solution(String s) {

        String str = s.replace("{", "");
        str = str.replace("}", "");
        String[] arr = str.split(",");

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));

        int[] answer = new int[keySet.size()];
        for (int i = 0; i < keySet.size(); i++) {
            answer[i] = Integer.parseInt(keySet.get(i));
        }

        return answer;
    }
}
