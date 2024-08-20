package backjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bitonic {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int S = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[S];
		for (int i = 0; i < S; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int[] d = new int[S];
		int max = 0;
		for (int i = 0; i < S; i++) {
			d[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && d[i] <= d[j]) {
					d[i] = d[j] + 1;
				}
			}
			max = Math.max(max, d[i]);
		}
		
		int[] rd = new int[S];
		max = 0;
		for (int i = S - 1; i >= 0; i--) {
			rd[i] = 1;
			for (int j = S - 1; j > i; j--) {
				if (arr[j] < arr[i] && rd[i] <= rd[j]) {
					rd[i] = rd[j] + 1;
				}
			}
			max = Math.max(max, rd[i]);
		}
		max = 0;
		for (int i = 0; i < S; i++) {
			max = Math.max(max, d[i] + rd[i]);
		}

		System.out.println(max - 1);
	}
}
