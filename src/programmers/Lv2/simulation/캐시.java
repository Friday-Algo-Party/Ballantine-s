package programmers.Lv2.simulation;

import java.util.*;

// [1차] 캐시, Programmers(Level 2, 2018 KAKAO BLIND RECRUITMENT)
public class 캐시 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> list = new LinkedList<>();
        boolean check = false;

        if (cacheSize == 0) {
            answer = cities.length * 5;
            return answer;
        }

        for (int i = 0; i < cities.length; i++) {
            String nowCity = cities[i].toLowerCase();
            check = false;

            if (list.size() >= cacheSize) {
                for (int j = 0; j < cacheSize; j++) {
                    if (list.get(j).equals(nowCity)) {
                        answer += 1;
                        list.add(nowCity);
                        list.remove(j);
                        check = true;
                        break;
                    }
                }
                if (check == false) {
                    answer += 5;
                    list.remove(0);
                    list.add(nowCity);
                }
            } else {
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).equals(nowCity)) {
                        answer += 1;
                        list.remove(j);
                        list.add(nowCity);
                        check = true;
                        break;
                    }
                }
                if (check == false) {
                    list.add(nowCity);
                    answer += 5;
                }
            }
        }
        return answer;
    }
}
