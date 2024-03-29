package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class editDistance {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = br.readLine();
		String B = br.readLine();

		int[][] dp = new int[A.length() + 1][B.length() + 1];
		for (int i = 1; i <= A.length(); i++) 
			dp[i][0] = i;
		for (int i = 1; i <= B.length(); i++) 
			dp[0][i] = i;
	
		for (int i = 1; i <= A.length(); i++) {
			for (int j = 1; j <= B.length(); j++) {
				if (A.charAt(i - 1) == B.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];
				else
					dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
			}
		}
		System.out.println(dp[A.length()][B.length()]);
	}
}