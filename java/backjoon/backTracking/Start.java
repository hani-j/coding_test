package backjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Start {
	static int[][] graph;
    static int N;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        makeTeam(0, 0);
        System.out.println(min);
    }

    public static void makeTeam(int index, int count) {
        if (count == N / 2) {
            diff();
            return;
        }
        if (index >= N) {
            return;
        }
        visited[index] = true;
        makeTeam(index + 1, count + 1);
        visited[index] = false;
        makeTeam(index + 1, count);
    }

    public static void diff() {
        int team1 = 0;
        int team2 = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    team1 += graph[i][j] + graph[j][i];
                } else if (!visited[i] && !visited[j]) {
                    team2 += graph[i][j] + graph[j][i];
                }
            }
        }

        min = Math.min(min, Math.abs(team1 - team2));
    }
}
