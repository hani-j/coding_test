package backjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Safe {
	static int[][] map;
	static boolean[][] visited;
	static int N;
	static int max = 0;
	static int result = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		max = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
			}
		}

		for (int h = 0; h <= max; h++) {
			int count = 0;
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && map[i][j] > h) {
						count++;
						count(h, i, j);
					}
				}
			}
			result = Math.max(result, count);
		}
		System.out.println(result);
	}
	
	public static void count(int h, int x, int y) {
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{x, y});
		visited[x][y] = true;

		while (!q.isEmpty()) {
			int[] n = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = n[0] + dx[i];
				int ny = n[1] + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] > h) {
					visited[nx][ny] = true;
					q.add(new int[] {nx, ny});
				}
			}
		}
	}
}