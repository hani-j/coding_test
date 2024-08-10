package backjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato2 {
	static int[][][] graph;
	static Queue<int[]> queue;
	static int N;
	static int M;
	static int H;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		graph = new int[H][N][M];
		queue = new LinkedList<>();

		boolean noZero = true;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					int n = Integer.parseInt(st.nextToken());
					graph[i][j][k] = n;
					if (n == 1)
						queue.add(new int[] {i, j, k});
					if (noZero && n == 0)
						noZero = false;
				}
			}
		}
		if (noZero) {
			System.out.println("0");
			return ;
		}
		int count = bfs();
		if (Arrays.stream(graph).flatMap(Arrays::stream).flatMapToInt(Arrays::stream).anyMatch(num -> num == 0)) {
			System.out.println("-1");
			return ;
		}

		System.out.println(count);
	}

	public static int bfs() {
		int[] dx = {0, 0, 0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0, 0, 0};
		int[] dz = {0, 0, 1, -1, 0, 0};

		int count = -1;
		while (!queue.isEmpty()) {
			int n = queue.size();
			count++;
			for (int i = 0; i < n; i++) {
				int[] c = queue.poll();
				for (int j = 0; j < 6; j++) {
					int nx = c[2] + dx[j];
					int ny = c[1] + dy[j];
					int nz = c[0] + dz[j];
	
					if (nx >= 0 && nx < M && ny >= 0 && ny < N && nz >= 0 && nz < H
						&& graph[nz][ny][nx] == 0) {
							graph[nz][ny][nx] = 1;
							queue.add(new int[] {nz, ny, nx});
					}
				}
			}
		}
		return count;
	}
}
