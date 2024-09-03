package backjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Night {
	static int N;
	static int[][] visited;
	static int[] d = new int[2];
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			visited = new int[N][N];
			min = Integer.MAX_VALUE;
			for (int[] v : visited)
				Arrays.fill(v, Integer.MAX_VALUE);

			StringTokenizer st = new StringTokenizer(br.readLine());
			int cx = Integer.parseInt(st.nextToken());
			int cy = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			d[0] = Integer.parseInt(st.nextToken());
			d[1] = Integer.parseInt(st.nextToken());
			visited[cx][cy] = 0;
			move(cx, cy);
			sb.append(visited[d[0]][d[1]]);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void move(int x, int y) {
		int[] dx = {-1, -1, -2, -2, 1, 1, 2, 2};
		int[] dy = {2, -2, 1, -1, 2, -2, 1, -1};
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{x, y});
		visited[x][y] = 0;

		while (!q.isEmpty()) {
			int[] n = q.poll();
			int c = visited[n[0]][n[1]];
			
			for (int i = 0; i < 8; i++) {
				int nx = n[0] + dx[i];
				int ny = n[1] + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && c + 1 < visited[nx][ny]) {
					visited[nx][ny] = c + 1;
					q.add(new int[]{nx, ny});
				}
			}
		}
	}
}
