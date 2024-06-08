package programmers;

public class longJump {
	static public long solution(int n) {
        if (n == 1) 
            return 1;
        if (n == 2) 
            return 2;

        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }

        return dp[n];
    }

	public static void main(String[] args) {
		int n = 4;
		int n2 = 3;

		System.out.println(solution(n));
		System.out.println(solution(n2));
	}
	
	// 시간초과 -> dp 로 풀어야 하는 문제

	// public long solution(int n) {
    //     long answer = 0;
    //     for (int i = 0; i <= n / 2; i++) {
    //         answer += cal(n - i, i);
    //         answer %= 1234567;
    //     }
    //     return answer;
    // }
    
    // public long cal(long n, long r) {
    //     long num = 1;
    //     if (r > n - r) {
    //         r = n - r;
    //     }
    //     for (long i = 0; i < r; i++) {
    //         num = (num * (n - i)) % 1234567L;
    //         num = (num / (i + 1)) % 1234567L;
    //     }
    //     return num % 1234567L;
    // }
}
