package baekjoon.stack;

import java.io.*;
import java.util.Stack;

// 문자열 폭발(stack), 골드 IV
public class 문자열폭발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bomb = br.readLine();
        int bombLen = bomb.length();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            stack.push(c);

            if (stack.size() >= bombLen) {
                boolean isBomb = true;

                for (int j = 0; j < bombLen; j++) {
                    if (stack.get(stack.size() - bombLen + j) != bomb.charAt(j)) {
                        isBomb = false;
                        break;
                    }
                }

                if (isBomb) {
                    for (int j = 0; j < bombLen; j++) {
                        stack.pop();
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            for (char ch : stack) {
                sb.append(ch);
            }
            System.out.println(sb);
        }
    }
}
