package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class main025 {
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

        for (int i = 0; i < N; i++) {
            DFS(i, 1);
            if (arrive)
                break;
        }
        if (arrive)
            System.out.println("1");
        else
            System.out.println("0");

    }

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
