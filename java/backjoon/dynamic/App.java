package backjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class App {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] m = new int[N];
		int[] c = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			m[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int max = 0;
		for (int i = 0; i < N; i++) {
			c[i] = Integer.parseInt(st.nextToken());
			max += c[i];
		}

		int[] d = new int[max + 1];
		for (int i = 0; i < N; i++) {
			for (int j = max; j >= c[i]; j--) {
				d[j] = Math.max(d[j], d[j - c[i]] + m[i]);
			}
		}

		for (int i = 0; i <= max; i++) {
			if (d[i] >= M) {
				System.out.println(i);
				break;
			}
		}
	}
}
