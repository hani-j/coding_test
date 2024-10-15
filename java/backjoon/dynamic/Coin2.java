package backjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Coin2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coin = new int[N];
		for (int i = 0; i < N; i++)
			coin[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(coin);
		int[] d = new int[K + 1];
		Arrays.fill(d, 100001);
		d[0] = 0;
		for (int i = 0; i < N; i++) {
			for (int j = coin[i]; j <= K; j++) {
				d[j] = Math.min(d[j], d[j - coin[i]] + 1);
			}
		}
		if (d[K] == 100001)
			System.out.println(-1);
		else
			System.out.println(d[K]);
	}
}
