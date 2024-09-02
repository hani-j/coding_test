package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Continuous {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[] prime = new boolean[N + 1];
		Arrays.fill(prime, true);
		for (int i = 2; i <= N; i++) {
			if (!prime[i])
				continue;
			for (int j = i * 2; j <= N; j += i) {
				prime[j] = false;
			}
		}

		int count = 0;
		for (int i = 2; i <= N; i++) {
			if (!prime[i])
				continue;
			int sum = i;
			int n = i + 1;
			while (sum < N && n < N) {
				if (prime[n])
					sum += n;
				n++;
			}
			if (sum == N)
				count++;
		}
		System.out.println(count);
	}
}
