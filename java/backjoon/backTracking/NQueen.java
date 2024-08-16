package backjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen {
	static int count = 0;
	static int N;
	static boolean[] col;
	static boolean[] d1;
	static boolean[] d2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		col = new boolean[N + 1];
		d1 = new boolean[N * 2 + 1];
		d2 = new boolean[N * 2 + 1];
		getCount(1);
		System.out.println(count);
	}

	public static void getCount(int r) {
		if (r == N + 1) {
			count++;
			return ;
		}
		for (int i = 1; i <= N; i++) {
			if (col[i] || d1[r - i + N] || d2[r + i])
				continue;
			col[i] = true;
			d1[r - i + N] = true;
			d2[r + i] = true;
			getCount(r + 1);
			col[i] = false;
			d1[r - i + N] = false;
			d2[r + i] = false;
		}
	}
}
