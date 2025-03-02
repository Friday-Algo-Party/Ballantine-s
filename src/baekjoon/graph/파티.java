package baekjoon.graph;

import java.io.*;
import java.util.*;

// 파티(graph), 골드 III
public class 파티 {
    static int N, M, X;
    static List<int[]>[] graph;         // 정방향
    static List<int[]>[] reverseGraph;  // 역방향 그래프
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 마을 개수
        M = Integer.parseInt(st.nextToken());   // 도로 개수
        X = Integer.parseInt(st.nextToken());   // 파티 장소

        graph = new ArrayList[N + 1];
        reverseGraph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            graph[from].add(new int[]{to, time});
            reverseGraph[to].add(new int[]{from, time}); // 역방향
        }

        int[] distToX = dijkstra(graph, X);

        int[] distFromX = dijkstra(reverseGraph, X);

        int maxTime = 0;
        for (int i = 1; i <= N; i++) {
            maxTime = Math.max(maxTime, distFromX[i] + distToX[i]);
        }

        System.out.println(maxTime);
    }

    public static int[] dijkstra(List<int[]>[] graph, int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int nowNode = current[0];
            int time = current[1];

            if (time > dist[nowNode]) continue;

            for (int[] next : graph[nowNode]) {
                int nextNode = next[0];
                int nextTime = time + next[1];

                if (nextTime < dist[nextNode]) {
                    dist[nextNode] = nextTime;
                    pq.add(new int[]{nextNode, nextTime});
                }
            }
        }
        return dist;
    }
}