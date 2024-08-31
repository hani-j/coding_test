package backjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backpack {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] d = new int[1001][100001];
		int[] w = new int[1001];
		int[] v = new int[1001];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			w[i] = W;
			v[i] = V;
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if (j >= w[i])
					d[i][j] = Math.max(d[i - 1][j], d[i - 1][j - w[i]] + v[i]);
				else
					d[i][j] = d[i - 1][j];
			}
		}
		
		System.out.println(d[N][K]);
	}
}
