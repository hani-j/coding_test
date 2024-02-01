package backjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// dynamic 11726
public class tile {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int N = Integer.parseInt(br.readLine());
		int[] d = new int[1001];

		d[1] = 1;
		d[2] = 2;
		for (int i = 3; i < 1001; i++) {
			d[i] = (d[i - 1] + d[i - 2]) % 10007;
		}
		System.out.println(d[N]);
	}
}
