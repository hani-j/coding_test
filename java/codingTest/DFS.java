package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DFS {
    static boolean visited[];
    static ArrayList<Integer>[] array;
    static boolean arrive;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        array = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            array[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            array[s].add(e);
            array[e].add(s);
        }

        // node 수만큼 돌면서 DFS 깊이 5 이상일 때 까지
        for (int i = 0; i < N; i++) {
            // 깊이 1부터 시작. 자기 자신이 1
            DFS(i, 1);
            if (arrive)
                break;
        }
        if (arrive)
            System.out.println("1");
        else
            System.out.println("0");

    }

    // DFS
    // 스택의 성질을 가진 재귀
    // 깊이가 5 이상일 때 까지 이어져 있는 모든 노드 방문 (조건은 달라질 수 있음)
    static void DFS(int v, int d) {
        if (d == 5 || arrive) {
            arrive = true;
            return;
        }
        visited[v] = true;
        for (int i : array[v]) {
            if (!visited[i])
                DFS(i, d+1);
        }
        visited[v] = false;
    }
}
