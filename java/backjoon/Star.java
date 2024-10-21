package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Star {
	static char[][] print;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		print = new char[N][N];

		star(0, 0, N);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				sb.append(print[i][j]);
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}

	public static void star(int x, int y, int n) {
		if (n == 3) {
			print[x][y] = '*';
			print[x][y + 1] = '*';
			print[x][y + 2] = '*';
			print[x + 1][y] = '*';
			print[x + 1][y + 1] = ' ';
			print[x + 1][y + 2] = '*';
			print[x + 2][y] = '*';
			print[x + 2][y + 1] = '*';
			print[x + 2][y + 2] = '*';
		} else {
			int s = n / 3;

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (i == 1 && j == 1)
						blank(x + i * s, y + j * s, s);
					else
						star(x + i * s, y + j * s, s);
				}
			}
		}
	}

	static void blank(int x, int y, int n) {
		for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++)
				print[i][j] = ' ';
		}
	}
}
