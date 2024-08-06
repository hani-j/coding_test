package backjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Cabbage {
	static int[][] graph;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			graph = new int[M][N];
			visited = new boolean[M][N];

			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				graph[X][Y] = 1;
			}

			int count = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if (graph[i][j] == 1 && !visited[i][j]) {
						dfs(i, j);
						count++;
					}
				}
			}
			sb.append(count + "\n");
		}
		System.out.println(sb.toString());
	}

	public static void dfs(int x, int y) {
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < graph.length && ny >= 0 && ny < graph[0].length && graph[nx][ny] == 1 && !visited[nx][ny])
				dfs(nx, ny);
		}
	}
}
