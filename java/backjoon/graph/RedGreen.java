package backjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RedGreen {
	static boolean[][] visited;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		String[][]graph1 = new String[N][N];
		String[][]graph2 = new String[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			String[] strs = str.split("");
			graph1[i] = strs;
			for (int j = 0; j < N; j++) {
				if (str.charAt(j) == 'G')
					graph2[i][j] = "R";
				else
					graph2[i][j] = str.charAt(j) + "";
			}
		}
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(graph1, i, j, graph1[i][j]);
					count++;
				}
			}
		}

		visited = new boolean[N][N];
		int rCount = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(graph2, i, j, graph2[i][j]);
					rCount++;
				}
			}
		}
		System.out.println(count + " " + rCount);
	}

	public static void dfs(String[][] graph, int x, int y, String c) {
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] 
				&& graph[nx][ny].equals(c))
				dfs(graph, nx, ny, c);
		}
	}
}
