package backjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Matrix {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] m = new int[N][2];
		long[][] d = new long[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			m[i][0] = r;
			m[i][1] = c;
		}
		
		for (int len = 1; len < N; len++) {
			for (int i = 0; i + len < N; i++) {
				int  j = i + len;
				d[i][j] = Integer.MAX_VALUE;
				for (int k = i; k < j; k++) {
					d[i][j] = Math.min(d[i][j], d[i][k] + d[k + 1][j] + m[i][0] * m[k][1] * m[j][1]);
				}
			}
		}
		System.out.println(d[0][N - 1]);
	}
}
