package programmers;

public class land {
	static int solution(int[][] land) 
    {
        int answer = 0;
        int[][] dp = new int[land.length][land[0].length];
        dp[0] = land[0];

        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (k == j)
                        continue;
                    dp[i][j] = Math.max(dp[i][j], land[i][j] + dp[i - 1][k]);
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }
        return answer;
    }

	public static void main(String[] args) {
		int[][] land = {{1,2,3,5}, {5,6,7,8}, {4,3,2,1}};
		System.out.println(solution(land));
	}
}
