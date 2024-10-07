package backjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Zelda {
	static int N;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int idx = 1;

		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			sb.append("Problem ");
			sb.append(idx++);
			sb.append(": ");
			sb.append(dijk());
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static int dijk() {
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};
		PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
		q.add(new int[]{0, 0, map[0][0]});
		
		int[][] visited = new int[N][N];
		for (int[] v : visited)
			Arrays.fill(v, Integer.MAX_VALUE);
		visited[0][0] = map[0][0];

		while (!q.isEmpty()) {
			int[] n = q.poll();
			if (n[2] > visited[n[0]][n[1]])
				continue;

			for (int i = 0; i < 4; i++) {
				int nx = n[0] + dx[i];
				int ny = n[1] + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && visited[nx][ny] == Integer.MAX_VALUE) {
					visited[nx][ny] = n[2] + map[nx][ny];
					q.add(new int[] {nx, ny, visited[nx][ny]});
				}
			}
		}
		return visited[N - 1][N - 1];
	}
}
