package backjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Coin {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		long[] d = new long[K + 1];
		d[0] = 1;

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			for (int j = arr[i]; j <= K; j++) {
				d[j] += d[j - arr[i]];
			}
		}
		System.out.println(d[K]);
	}
}
