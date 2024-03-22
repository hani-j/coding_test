package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class gold {
	static int[][] arr;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t< T; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			arr = new int[n][m];
			dp = new int[n][m];
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
				dp[i][0] = arr[i][0];
			}

			for (int j = 1; j < m; j++) {
				for (int i = 0; i < n; i++) {
					int left_up = 0;
					if (i == 0)
						left_up = 0;
					else
						left_up = dp[i - 1][j - 1];
					
					int left_down = 0;
					if (i == n - 1)
						left_down = 0;
					else
						left_down = dp[i + 1][j - 1];
					
					int left = dp[i][j - 1];
					dp[i][j] = arr[i][j] + Math.max(left_down, Math.max(left_up, left));
				}
			}

			int result = 0;
			for (int i = 0; i < n; i++) {
				result = Math.max(result, dp[i][m - 1]);
			}
			sb.append(result + "\n");
		}
		System.out.println(sb.toString());
	}
}
