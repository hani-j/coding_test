package backjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Func {
	static int[][][] arr = new int[51][51][51];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a == -1 && b == -1 && c == -1)
				break;
			sb.append("w(" + a + ", " + b + ", " + c + ") = ");
			int result = w(a, b, c);
			sb.append(result + "\n");
			
		}
		System.out.println(sb.toString());
	}
	
	public static int w (int a, int b, int c) {

		if (a <= 0 || b <= 0 || c <= 0)
			return 1;
		if (arr[a][b][c] > 0)
			return arr[a][b][c];

		if (a > 20 || b > 20 || c > 20) {
			arr[a][b][c] = w(20, 20, 20);
			return arr[a][b][c];
		}
		if (a < b && b < c) {
			arr[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w (a, b - 1, c);
			return arr[a][b][c];
		}
		else {
			arr[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
			return arr[a][b][c];
		}
	}
}
