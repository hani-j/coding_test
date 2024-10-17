package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Chess {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		char[][] arr = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++)
				arr[i][j] = str.charAt(j);
		}

		int[][] W = new int[N + 1][M + 1];
		int[][] B = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				boolean white = (i + j) % 2 == 0;

				W[i][j] = W[i - 1][j] + W[i][j - 1] - W[i - 1][j - 1];
				if ((white && arr[i - 1][j - 1] == 'W') || (!white && arr[i - 1][j - 1] == 'B')) {
					W[i][j]++;
				}

				B[i][j] = B[i - 1][j] + B[i][j - 1] - B[i - 1][j - 1];
				if ((white && arr[i - 1][j - 1] == 'B') || (!white && arr[i - 1][j - 1] == 'W')) {
					B[i][j]++;
				}
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = K; i <= N; i++) {
			for (int j = K; j <= M; j++) {
				int w = W[i][j] - W[i - K][j] - W[i][j - K] + W[i - K][j - K];
				int b = B[i][j] - B[i - K][j] - B[i][j - K] + B[i - K][j - K];
				
				min = Math.min(min, Math.min(w, b));
			}
		}
		System.out.println(min);
	}

	// public static int count(int x, int y) {
	// 	int W = 0;
	// 	int B = 0;

	// 	for (int i = x; i < x + K; i++) {
	// 		for (int j = y; j < y + K; j++) {
	// 			if ((i + j) % 2 == 0) {
	// 				if (arr[i][j] != 'W')
	// 					W++;
	// 				if (arr[i][j] != 'B')
	// 					B++;
	// 			} else {
	// 				if (arr[i][j] != 'B')
	// 					W++;
	// 				if (arr[i][j] != 'W')
	// 					B++;
	// 			}
	// 		}
	// 	}
	// 	return Math.min(W, B);
	// }
}
