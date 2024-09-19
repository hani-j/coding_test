package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gas {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] distance = new int[N - 1];
		int[] price = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++)
			distance[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			price[i] = Integer.parseInt(st.nextToken());
		
		int idx = 0;
		long sum = 0;
		while (idx < N - 1) {
			long p = price[idx];
			long d = distance[idx];
			idx++;
			while (idx < N - 1 && p < price[idx]) {
				d += distance[idx];
				idx++;
			}
			sum += p * d;
		}
		System.out.println(sum);
	}
}
