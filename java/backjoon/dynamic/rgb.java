package backjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// dynamic 1149
public class rgb {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][3];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}	
		}

		int[][] d = new int[N][3];
		d[0][0] = arr[0][0];
		d[0][1] = arr[0][1];
		d[0][2] = arr[0][2];

		for (int i = 1; i < N; i++) {
			d[i][0] = arr[i][0] + Math.min(d[i - 1][1], d[i - 1][2]);
			d[i][1] = arr[i][1] + Math.min(d[i - 1][0], d[i - 1][2]);
			d[i][2] = arr[i][2] + Math.min(d[i - 1][0], d[i - 1][1]);
		}
		System.out.println(Math.min(Math.min(d[N - 1][0], d[N - 1][1]), d[N - 1][2]));
	}
}
