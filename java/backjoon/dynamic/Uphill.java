package backjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Uphill {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int	N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N + 1][10];
		Arrays.fill(dp[1], 1);

		for(int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k <= j; k++) {
					dp[i][j] += dp[i - 1][k];
					dp[i][j] %= 10007;
				}
			}
		}

		long count = 0;
		for (int i = 0; i < 10; i++)
			count += dp[N][i];

		System.out.println(count % 10007);
	}
}
