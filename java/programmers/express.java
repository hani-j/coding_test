package programmers;

import java.util.HashSet;
import java.util.Set;

public class express {
	static public int solution(int N, int number) {
        Set<Integer>[] dp = new Set[9];
        
        for (int i = 1; i < 9; i++) {
            dp[i] = new HashSet<>();
        }
        
        for (int i = 1; i < 9; i++) {
            int num = Integer.parseInt(String.valueOf(N).repeat(i));
            dp[i].add(num);
        }
        
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < i; j++) {
                for (int a : dp[j]) {
                    for (int b : dp[i - j]) {
                        dp[i].add(a + b);
                        dp[i].add(a - b);
                        dp[i].add(a * b);
                        if (b != 0) {
                            dp[i].add(a / b);
                        }
                    }
                }
            }
            if (dp[i].contains(number)) {
                return i;
            }
        }
        
        return -1;
    }

	public static void main(String[] args) {
		int N = 5;
		int number = 12;

		System.out.println(solution(N, number));;
	}
}
