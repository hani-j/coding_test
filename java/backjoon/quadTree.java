package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 26-2 1992
public class quadTree {
	static String[][] arr;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new String[N][N];
		sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().split("");
		}
		devide(0, 0, N);
		System.out.println(sb.toString());
	}

	static public void devide(int s, int e, int n) {
		if (isSquare(s, e, n)) {
			sb.append(arr[s][e]);
		} else {
			if (n < 2)
				return ;
			sb.append("(");
			devide(s, e, n/2);
			devide(s, e + n/2, n/2);
			devide(s + n/2, e, n/2);
			devide(s + n/2, e + n/2, n/2);
			sb.append(")");
		}
	}

	static public boolean isSquare(int s, int e, int n) {
		String num = arr[s][e];
		for (int i = s; i < s + n; i++) {
			for (int j = e; j < e + n; j++) {
				if (!arr[i][j].equals(num))
					return false;
			}
		}
		return true;
	}
}
