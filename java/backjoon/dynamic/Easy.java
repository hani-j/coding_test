package backjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Easy {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] d = new int[N + 1][10];

		for (int i = 1; i < 10; i++){
			d[1][i] = 1;
		}
		
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				if (j > 0)
					d[i][j] = (d[i][j] + d[i - 1][j - 1]) % 1000000000;
				if (j < 9)
					d[i][j] = (d[i][j] + d[i - 1][j + 1]) % 1000000000;
			}
		}

		int count = 0;
		for (int i = 0; i < 10; i++) {
			count = (count + d[N][i]) % 1000000000;
		}

		System.out.println(count);
	}

}
