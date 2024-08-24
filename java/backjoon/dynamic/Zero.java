package backjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zero {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if (N < 3) {
			System.out.println(N);
			return ;
		}

		int[] d = new int[N];
		d[0] = 1;
		d[1] = 2;
		
		for (int i = 2; i < N; i++) {
			d[i] = (d[i - 2] + d[i - 1]) % 15746;
		}
		System.out.println(d[N - 1]);
	}
}
