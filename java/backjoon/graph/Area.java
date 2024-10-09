package backjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Area {
	static boolean[][] map;
	static boolean[][] visited;
	static int M;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		map = new boolean[M][N];
		visited = new boolean[M][N];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			fill(x1, y1, x2, y2);
		}
		int count = 0;
		List<Integer> l = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && !map[i][j]) {
					count++;
					l.add(bfs(i, j));
				}
			}
		}
		l.sort(null);
		StringBuilder sb = new StringBuilder();
		sb.append(count);
		sb.append("\n");
		for (int n : l) {
			sb.append(n);
			sb.append(" ");
		}
		System.out.println(sb);;
	}

	public static void fill(int x1, int y1, int x2, int y2) {
		for (int i = y1; i < y2; i++) {
			for (int j = x1; j < x2; j++)
				map[i][j] = true;
		}
	}

	public static int bfs(int x, int y) {
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{x, y});
		visited[x][y] = true;

		int count = 1;
		while (!q.isEmpty()) {
			int[] n = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = n[0] + dx[i];
				int ny = n[1] + dy[i];
				if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[nx][ny] && !map[nx][ny]) {
					visited[nx][ny] = true;
					q.add(new int[]{nx, ny});
					count++;
				}
			}
		}
		return count;
	}
}
