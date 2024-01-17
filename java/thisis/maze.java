package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 05-02
public class maze {
	static int[][] arr;
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(split[j]);
 			}
		}
		BFS(0, 0);
		System.out.println(arr[N-1][M-1]);
	}

	private static int BFS(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{x, y});
		int dx[] = {-1, 1, 0, 0};
		int dy[] = {0, 0, -1, 1};

		while (!queue.isEmpty()) {
			int[] dir = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = dir[0] + dx[i];
				int ny = dir[1] + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				if (arr[nx][ny] == 0)
					continue;
				if (arr[nx][ny] == 1) {
					arr[nx][ny] = arr[dir[0]][dir[1]] + 1;
					queue.add(new int[]{nx, ny});
				}
			}
		}
		return arr[N - 1][M - 1];
	}
}
