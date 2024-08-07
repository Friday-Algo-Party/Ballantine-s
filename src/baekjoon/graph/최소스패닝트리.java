package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 최소 스패닝 트리(graph), 골드 IV
public class 최소스패닝트리 {
    static int result;
    static List<Node>[] list;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        list = new ArrayList[V + 1];
        visited = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[from].add(new Node(to, cost));
            list[to].add(new Node(from, cost));
        }
        prim(1);
        System.out.println(result);
    }

    public static void prim(int start) {
        Queue<Node> queue = new PriorityQueue<>();  // 우선순위 큐
        queue.offer(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int to = now.to;
            int cost = now.cost;

            if (visited[to]) {  // 이미 정점을 방문 했다면 continue
                continue;
            }

            visited[to] = true;
            result += cost;     // 방문하지 않은 정점에 방문했다면 총합 변수에 더해주기

            for (Node next : list[to]) {
                if (!visited[next.to]) {
                    queue.add(next);
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
