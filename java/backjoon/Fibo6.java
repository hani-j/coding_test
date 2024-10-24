package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibo6 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());

		long[][] base = {{1, 1}, {1, 0}};
		if (N == 0)
			System.out.println(0);
		else {
			long[][] result = power(base, N - 1);
			System.out.println(result[0][0]);
		}
	}

	public static long[][] power(long[][] base, long e) {
		long[][] result = {{1, 0}, {0, 1}};
		while (e > 0) {
			if (e % 2 == 1)
				result = multi(result, base);
			base = multi(base, base);
			e /= 2;
		}
		return result;
	}

	public static long[][] multi(long[][] A, long[][] B) {
		long[][] result = new long[2][2];
		int mod = 1000000007;
        result[0][0] = (A[0][0] * B[0][0] + A[0][1] * B[1][0]) % mod;
        result[0][1] = (A[0][0] * B[0][1] + A[0][1] * B[1][1]) % mod;
        result[1][0] = (A[1][0] * B[0][0] + A[1][1] * B[1][0]) % mod;
        result[1][1] = (A[1][0] * B[0][1] + A[1][1] * B[1][1]) % mod;

        return result;
	}
}
