package backjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// dynamic 2839
public class sugar {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] d = new int[5001];
		for (int i = 3; i <= N; i += 3) {
			d[i] = i / 3;
		}

		for (int i = 5; i <= N; i++) {
			if (i % 5 == 0)
				d[i] = d[i - 5] + 1;
			else if (d[i - 3] != 0)
				d[i] = d[i - 3] + 1;
		}
		if (d[N] == 0)
			System.out.println("-1");
		else
			System.out.println(d[N]);
	}
}
