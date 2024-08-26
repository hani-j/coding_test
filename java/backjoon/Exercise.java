package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int[][] graph = new int[V + 1][V + 1];
		for (int i = 1; i <= V; i++) {
			Arrays.fill(graph[i], Integer.MAX_VALUE);
			graph[i][i] = 0;
		}

		for (int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a][b] = c;
		}

		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				for (int k = 1; k <= V; k++) {
					if (graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE)
						graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i != j && graph[i][j] != Integer.MAX_VALUE && graph[j][i] != Integer.MAX_VALUE) {
                    min = Math.min(min, graph[i][j] + graph[j][i]);
                }
            }
        }
		if (min == Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(min);
	}
}
