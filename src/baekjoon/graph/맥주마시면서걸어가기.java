package baekjoon.graph;

import java.util.*;
import java.io.*;

// 맥주 마시면서 걸어가기(graph), 골드 V
public class 맥주마시면서걸어가기 {
    static List<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        ArrayList<Node> place;
        ArrayList<ArrayList<Integer>> graph;

        int t = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < t; testCase++) {
            int n = Integer.parseInt(br.readLine());

            place = new ArrayList<>();
            for (int i = 0; i < n + 2; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                place.add(new Node(x, y));
            }

            graph = new ArrayList<>();
            for (int i = 0; i < n + 2; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < n + 2; i++) {
                for (int j = i + 1; j < n + 2; j++) {
                    if (Math.abs(place.get(i).x - place.get(j).x) + Math.abs(place.get(i).y - place.get(j).y) <= 1000) {
                        graph.get(i).add(j);
                        graph.get(j).add(i);
                    }
                }
            }

            if (BFS(graph, n)) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }
        }
    }

    public static boolean BFS(ArrayList<ArrayList<Integer>> graph, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        boolean[] visited = new boolean[n + 2];
        visited[0] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == n + 1) {
                return true;
            }

            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
        return false;
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
