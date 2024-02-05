package backjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// dynamic 1932
public class triangle {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] d = new int[N][N];
		d[0][0] = arr[0][0];

		for (int i = 1; i < N; i++) {
			d[i][0] = d[i - 1][0] + arr[i][0];
			d[i][i] = d[i - 1][i - 1] + arr[i][i];
			for (int j = 1; j < i; j++) {
				d[i][j] = arr[i][j] + Math.max(d[i - 1][j - 1], d[i - 1][j]);
			}
		}
		int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, d[N - 1][i]);
        }

        System.out.println(max);
	}
}
