package backjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato {
	static int[][] graph;
	static Queue<int[]> queue;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		graph = new int[N][M];
		queue = new LinkedList<>();

		boolean noZero = true;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int n = Integer.parseInt(st.nextToken());
				graph[i][j] = n;
				if (n == 0)
					noZero = false;
				else if (n == 1)
					queue.add(new int[]{i, j});
			}
		}
		if (noZero) {
			System.out.println(0);
			return ;
		}

		int count = bfs();
		if (Arrays.stream(graph).flatMapToInt(Arrays::stream)
			.anyMatch(num -> num == 0)) {
				System.out.println("-1");
				return ;
		}
				
		System.out.println(count);
	}

	public static int bfs() {
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};
		
		int count = -1;

		while (!queue.isEmpty()) {
			int N = queue.size();
			count++;
			for (int n = 0; n < N; n++) {
				int[] c = queue.poll();
				int x = c[0];
				int y = c[1];

				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];

					if (nx >= 0 && nx < graph.length && ny >= 0 && ny < graph[0].length 
						&& graph[nx][ny] == 0) {
							graph[nx][ny] = 1;
							queue.add(new int[]{nx, ny});
						}
				}
			}
		}
		
		return count;
	}
}