package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Guitar {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] packs = new int[M];
		int[] each = new int[M];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			packs[i] = Integer.parseInt(st.nextToken());
			each[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(packs);
		Arrays.sort(each);

		int sum = 0;
		while (N > 0) {
			int n = 6;
			if (N < 6)
				n = N;
			if (each[0] * n < packs[0]) {
				sum += each[0] * n;
				N -= n;
			} else {
				sum += packs[0];
				N -= 6;
			}
		}
		System.out.println(sum);
	}
}
