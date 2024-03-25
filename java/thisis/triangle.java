package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class triangle {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				int up_left = 0;
				if (j != 0)
					up_left = dp[i - 1][j - 1];
				int up = 0;
				if (j != i)
					up = dp[i - 1][j];
				dp[i][j] = dp[i][j] + Math.max(up_left, up);
			}
		}
		Arrays.sort(dp[n - 1]);
		System.out.println(dp[n - 1][n - 1]);
	}
}
