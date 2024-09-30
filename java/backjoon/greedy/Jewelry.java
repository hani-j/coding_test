package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Jewelry {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		List<int[]> l = new ArrayList<>();
		int[] B = new int[K];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			l.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		for (int i = 0; i < K; i++) {
			B[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(B);
		l.sort((a, b) -> Integer.compare(a[0], b[0]));

		PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
		long sum = 0;
		int idx = 0;
		for (int b : B) {
			while (idx < N && l.get(idx)[0] <= b) {
				q.add(l.get(idx)[1]);
				idx++;
			}
			if (!q.isEmpty())
				sum += q.poll();
		}
		System.out.println(sum);
	}
}
