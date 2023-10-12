package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class main047 {
    static boolean[] visited;
    static ArrayList<Integer>[] array;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        array = new ArrayList[N + 1];
        answer = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            array[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            array[S].add(E);
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            BFS(i);
        }
        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, answer[i]);
        }
        for (int i = 1; i <= N; i++) {
            if (answer[i] == max)
                System.out.print(i + " ");
        }

    }

    public static void BFS(int Node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(Node);
        visited[Node] = true;

        while (!queue.isEmpty()) {
            int nNode = queue.poll();
            for (int i : array[nNode]) {
                if (!visited[i]) {
                    visited[i] = true;
                    answer[i]++;
                    queue.add(i);
                }
            }
        }
    }
}
