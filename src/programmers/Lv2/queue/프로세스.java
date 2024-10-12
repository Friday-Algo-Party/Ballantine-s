package programmers.Lv2.queue;

import java.util.*;

// 프로세스, Programmers(Level 2, 스택/큐)
public class 프로세스 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        boolean[] visited = new boolean[priorities.length];
        Queue<int[]> que = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            que.offer(new int[]{i, priorities[i]});
        }

        while (!que.isEmpty()) {
            int[] now = que.poll();
            int nowNum = now[0];
            int priority = now[1];
            visited[nowNum] = true;

            boolean isHighPriority = false;

            for (int i = 0; i < priorities.length; i++) {
                if (visited[i] == true) {
                    continue;
                }
                if (priority < priorities[i]) {
                    isHighPriority = true;
                    break;
                }
            }

            if (isHighPriority) {
                que.offer(new int[]{nowNum, priority});
                visited[nowNum] = false;
            } else {
                answer++;
                if (nowNum == location) {
                    break;
                }
            }
        }
        return answer;
    }
}
