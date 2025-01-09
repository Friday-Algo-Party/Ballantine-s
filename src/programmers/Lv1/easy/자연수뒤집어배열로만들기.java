package programmers.Lv1.easy;

import java.util.ArrayList;
import java.util.List;

// 자연수 뒤집어 배열로 만들기, Programmers(Level 1)
public class 자연수뒤집어배열로만들기 {
    public int[] solution(long n) {
        List<Long> list = new ArrayList<>();

        while (n > 0) {
            list.add(n % 10);
            n /= 10;
        }

        return list.stream().mapToInt(Long::intValue).toArray();
    }
}
