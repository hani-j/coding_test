package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 21-1 27433
public class factorial {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long factorial = calculate(N);
		System.out.println(factorial);
	}

	private static long calculate(int n) {
		if (n == 0)
			return 1;
		return n * calculate(n-1);
	}
}