package backjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Land {
	static int[][] map;
	static int h;
	static int w;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if (w == 0 && h == 0)
				break;

			map = new int[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			sb.append(count());
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static int count() {
		int count = 0;
		boolean[][] visited = new boolean[h][w];

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					dfs(visited, i, j);
					count++;
				}
			}
		}
		return count;
	}

	public static void dfs(boolean[][] visited, int x, int y) {
		int[] dx = {0, 0, 1, -1, -1, -1, 1, 1};
		int[] dy = {1, -1, 0, 0, -1, 1, -1, 1};

		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < h && ny >= 0 && ny < w && !visited[nx][ny] && map[nx][ny] == 1) {
				visited[nx][ny] = true;
				dfs(visited, nx, ny);
			}
		}
	}
}
