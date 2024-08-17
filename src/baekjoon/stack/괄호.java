package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 괄호(stack), 실버 IV
public class 괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < T; testCase++) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();     // 스택 초기화

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);     // 한 문자씩 받기

                if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.isEmpty()) {
                        stack.push(c);
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if (stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
