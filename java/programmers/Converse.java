package programmers;

import java.util.Arrays;

public class Converse {
	static public int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[x] = 0;
        
        for (int i = x; i <= y; i++) {
            if (i % 2 == 0 && dp[i / 2] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if (i % 3 == 0 && dp[i / 3] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
            if (i >= x + n && dp[i - n] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i - n] + 1);
            }
        }
        
        if (dp[y] == Integer.MAX_VALUE)
            return -1;
        return dp[y];
    }

	public static void main(String[] args) {
		int x1 = 10;
		int y1 = 40;
		int n1 = 5;
		System.out.println(solution(x1, y1, n1));

		int x2 = 10;
		int y2 = 40;
		int n2 = 30;
		System.out.println(solution(x2, y2, n2));

		int x3 = 2;
		int y3 = 5;
		int n3 = 4;
		System.out.println(solution(x3, y3, n3));
	}
}
