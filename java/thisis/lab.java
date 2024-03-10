package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class lab {
	static int[][] arr;
	static int[][] tmp;
	static int result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		tmp = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0);
		System.out.println(result);
	}
	
	private static void virus(int x, int y) {
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length) {
				if (tmp[nx][ny] == 0) {
					tmp[nx][ny] = 2;
					virus(nx, ny);
				}
			}
		}
	}

	private static int getScore() {
		int score = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (tmp[i][j] == 0)
					score++;
			}
		}
		return score;
	}

	private static void dfs(int count) {
		if (count == 3) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[0].length; j++) {
					tmp[i][j] = arr[i][j];
				}
			}
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[0].length; j++) {
					if (tmp[i][j] == 2)
						virus(i, j);
				}
			}
			result = Math.max(result, getScore());
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 0) {
					arr[i][j] = 1;
					count++;
					dfs(count);
					arr[i][j] = 0;
					count--;
				}
			}
		}
	}
}
