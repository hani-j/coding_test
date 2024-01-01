package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class fibonacci {
	static int N;
	static int sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		System.out.println(calculate(N));
	}

	private static int calculate(int N) {
		if (N == 0)	return 0;
		else if (N == 1)	return 1;
		return calculate(N - 1) + calculate(N - 2);
	}
}
