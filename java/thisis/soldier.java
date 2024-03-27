package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class soldier {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N];
		int[] count = new int[N];
		for (int i = N - 1; i >= 0; i--) {
			dp[i] = arr[i];
			count[i] = 1;
			for (int j = i; j < N; j++) {
				if (arr[i] > arr[j]) {
					if (arr[i] + dp[j] > dp[i]) {
						dp[i] = arr[i] + dp[j];
						count[i] = count[j] + 1;
					}
				}
			}
		}
		int max = 0;
		int idx = 0;
		for (int i = 0; i < N; i++) {
			if (dp[i] > max) {
				max = dp[i];
				idx = i;
			}
		}
		System.out.println(N - count[idx]);
	}
}

// 15 11 4 8 5 2 4
// 43 28 6 17 9 2 4

// 43 28 17 9 6 4 2
// 0  1  3  4 2 6 5