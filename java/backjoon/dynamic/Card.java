package backjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Card {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N + 1];
		for (int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		int[] d = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			d[i] = arr[i];
			for (int j = 1; j < i; j++)
				d[i] = Math.max(d[i], d[j] + d[i - j]);
		}
		System.out.println(d[N]);
	}
}
