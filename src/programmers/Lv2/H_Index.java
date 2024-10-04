package programmers.Lv2;

import java.util.Arrays;

// H-Index, Programmers(Level 2)
public class H_Index {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations.length - i <= citations[i]) {
                answer = citations.length - i;
            }
        }
        return answer;
    }
}
