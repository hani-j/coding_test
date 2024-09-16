package backjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sticker {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[2][N];
			int[][] d = new int[2][N];
			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)
					arr[i][j] = Integer.parseInt(st.nextToken());
			}
			if (N == 1) {
				sb.append(Math.max(arr[0][0], arr[1][0]));
				sb.append("\n");
				continue;
			}

			d[0][0] = arr[0][0];
			d[1][0] = arr[1][0];
			d[0][1] = d[1][0] + arr[0][1];
			d[1][1] = d[0][0] + arr[1][1];
			for (int i = 2; i < N; i++) {
				d[0][i] = Math.max(d[1][i - 2], d[1][i - 1]) + arr[0][i];
				d[1][i] = Math.max(d[0][i - 2], d[0][i - 1]) + arr[1][i];
			}
			sb.append(Math.max(d[0][N - 1], d[1][N - 1]));
			sb.append("\n");
		}
		System.out.println(sb);
	}	
}
