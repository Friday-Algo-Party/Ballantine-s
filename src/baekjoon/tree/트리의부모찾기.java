package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 트리의 부모 찾기(tree), 실버 II
public class 트리의부모찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());       // 노드 개수

        ArrayList<Integer>[] tree = new ArrayList[N + 1];   // 연결 리스트 배열

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        boolean[] visited = new boolean[N + 1];     // 방문 배열
        int[] parent = new int[N + 1];              // 부모 노드를 저장하는 배열

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);                               // 루트 노드 1 큐에 넣음
        visited[1] = true;
        while (!queue.isEmpty()) {
            int curNode = queue.poll();
            for (int next : tree[curNode]) {        // 현재 노드에 연결된 노드 탐색
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    parent[next] = curNode;         // 다음 노드의 부모는 현재 노드이므로 따로 저장 시킴
                }
            }
        }

        for (int i = 2; i <= N; i++)                // 루트 노드를 제외한 노드의 부모 노드 출력
            System.out.println(parent[i]);
    }
}