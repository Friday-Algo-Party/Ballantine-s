package programmers.Lv2;

// 다음 큰 숫자, Programmers(Level 2)
public class 다음큰숫자 {
    class Solution {
        public int solution(int n) {
            int oneCnt = 0;
            String binary = Integer.toBinaryString(n);
            for (int i = 0; i < binary.length(); i++) {
                if (binary.charAt(i) == '1') {
                    oneCnt++;
                }
            }

            while (true) {
                int nextOneCnt = 0;
                ++n;
                String nextBinary = Integer.toBinaryString(n);
                for (int i = 0; i < nextBinary.length(); i++) {
                    if (nextBinary.charAt(i) == '1') {
                        nextOneCnt++;
                    }
                }
                if (nextOneCnt == oneCnt) {
                    break;
                }
            }
            return n;
        }
    }
}
