package backjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ComplexNum {
	static int[][] graph;
	static boolean[][] visited;
	static List<Integer> count;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		visited = new boolean[N][N];
		count = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				if (str.charAt(j) == '1')
					graph[i][j] = 1;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (graph[i][j] == 1 && !visited[i][j])
					bfs(i, j);
			}
		}
		count.sort(null);
		StringBuilder sb = new StringBuilder();
		sb.append(count.size() + "\n");
		for (Integer n : count)
			sb.append(n + "\n");
		System.out.println(sb.toString());
	}

	public static void bfs(int x, int y) {
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};
		Queue<Integer[]> queue = new LinkedList<>();
		queue.add(new Integer[] {x, y});
		visited[x][y] = true;
		int c = 1;

		while (!queue.isEmpty()) {
			Integer[] cu = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + cu[0];
				int ny = dy[i] + cu[1];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && graph[nx][ny] == 1 && !visited[nx][ny]) {
					queue.add(new Integer[]{nx, ny});
					visited[nx][ny] = true;
					c++;
				}
			}
		}
		count.add(c);
	}
}
