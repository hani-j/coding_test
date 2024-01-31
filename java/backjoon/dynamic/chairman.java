package backjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// dynamic 2775
public class chairman {
	static int[][] d;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		d = new int[15][15];
		for (int i = 0; i < 15; i++) {
			d[i][1] = 1;
			d[0][i] = i;
		}

		for (int i = 1; i < 15; i++) {
			for (int j = 2; j < 15; j++) {
				d[i][j] = d[i][j - 1] + d[i - 1][j];
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			sb.append(d[k][n] + "\n");
		}
		System.out.println(sb.toString());
	}
}
