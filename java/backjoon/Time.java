package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Time {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] graph = new int[N + 1][N + 1];
		for (int i = 0; i <= N; i++) {
			Arrays.fill(graph[i], Integer.MAX_VALUE);
			graph[i][i] = 0;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a][b] = Math.min(graph[a][b], c);
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE)
						graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}

		boolean path = false;
		for (int i = 2; i <= N; i++) {
			if (graph[1][i] != Integer.MAX_VALUE) {
				path = true;
				break;
			}
		}
		for (int i = 1; i <= N; i++) {
            if (path && graph[i][i] < 0) {
                System.out.println("-1");
                return;
            }
        }

		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= N; i++) {
			int n = graph[1][i];
			if (n != Integer.MAX_VALUE) {
				sb.append(n + "\n");
			} else
				sb.append("-1\n");
		}
		System.out.println(sb.toString());
	}
}
