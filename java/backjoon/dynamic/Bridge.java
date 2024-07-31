package backjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bridge {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[][] d = new int[N + 1][M + 1];
			for (int i = 0; i <= M; i++) {
				d[0][i] = 1;
			}
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					d[i][j] = d[i][j - 1];
					if (i <= j) {
						d[i][j] += d[i - 1][j - 1];
					}
				}
			}
			sb.append(d[N][M] + "\n");
		}
		System.out.println(sb.toString());
	}
}
