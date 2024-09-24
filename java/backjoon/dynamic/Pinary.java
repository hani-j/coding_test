package backjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pinary {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] d = new long[N];
		if (N == 1) {
			System.out.println("1");
			return ;
		}
		
		d[0] = 1;
		d[1] = 1;
		for (int i = 2; i < N; i++)
			d[i] = d[i - 2] + d[i - 1];
		System.out.println(d[N - 1]);
	}
}
