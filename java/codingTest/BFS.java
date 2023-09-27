package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS {
    static boolean visited[];
    static ArrayList<Integer>[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        array = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            array[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            array[s].add(e);
            array[e].add(s);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(array[i]);
        }
        visited = new boolean[N + 1];
        BFS(start);
        System.out.println();
    }

    // BFS
    // 선입선출 방식의 Queue 
    public static void BFS(int n) {
        Queue<Integer> queue = new LinkedList<Integer>();
        
        // 시작 노드 삽입
        queue.add(n);
        visited[n] = true;

        while (!queue.isEmpty()) {
            int now_n = queue.poll();
            System.out.print(now_n + "");
            // 방문 한 곳을 제외하고 인접 노드 큐에 삽입
            for (int i : array[now_n]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
