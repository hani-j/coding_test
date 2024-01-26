package backjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// dynamic 1463
public class makeOne {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] d = new int[1000001];

		for (int i = 2; i <= N; i++) {
			d[i] = d[i - 1] + 1;

			if (i % 3 == 0)
				d[i] = d[i / 3] + 1 < d[i] ? d[i / 3] + 1 : d[i];
			if (i % 2 == 0)
				d[i] = d[i / 2] + 1 < d[i] ? d[i / 2] + 1 : d[i];
		}
		System.out.println(d[N]);
	}
}
