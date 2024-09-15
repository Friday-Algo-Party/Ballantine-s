package programmers.Lv2;

import java.util.Stack;

// 짝지어 제거하기, Programmers(Level 2)
public class 짝지어제거하기 {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (!stack.isEmpty() && stack.peek() == currentChar) {
                stack.pop();
            } else {
                stack.push(currentChar);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
