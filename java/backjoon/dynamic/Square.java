package backjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Square {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] d = new int[N + 1];
		
		for (int i = 1; i <= N; i++)
			d[i] = i;

		for (int i = 2; i <= N; i++) {
			int s = (int) Math.sqrt(i);
			for (int j = 1; j <= s; j++) {
				d[i] = Math.min(d[i], d[i - j * j] + 1);
			}
		}
		System.out.println(d[N]);
	}
}
