package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hanoi {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int count = (int) Math.pow(2, N) - 1;
		sb.append(count).append('\n');
		hanoi(N, 1, 3, 2);
		System.out.println(sb);
	}

	public static void hanoi(int n, int a, int c, int b) {
		if (n == 1) {
			sb.append(a).append(' ').append(c).append('\n');
			return;
		}

		hanoi(n - 1, a, b, c);
		sb.append(a).append(' ').append(c).append('\n');
		hanoi(n - 1, b, c, a);
	}
}
