package programmers.Lv2;

import java.util.HashSet;
import java.util.Set;

// 영어 끝말잇기, Programmers(Level 2)
public class 영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        int num = 0;
        int count = 0;
        char lastChar = ' ';
        Set<String> set = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (set.isEmpty()) {
                set.add(word);
                lastChar = word.charAt(word.length() - 1);
                num++;
                count++;
            } else if (lastChar == word.charAt(0) && !set.contains(word)) {
                set.add(word);
                lastChar = word.charAt(word.length() - 1);
                num++;
                if (num == n) {
                    num %= n;
                    count++;
                }
            } else {
                num += 1;
                answer[0] = num;
                answer[1] = count;
                break;
            }
        }
        return answer;
    }
}
