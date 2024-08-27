package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Specific {
	static List<int[]>[] list;
	static int[] distance;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		list = new List[N + 1];
		distance = new int[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new int[]{b, c});
			list[b].add(new int[]{a, c});
		}
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		int min = Integer.MAX_VALUE;
		dijk(1);
		int a1 = distance[v1];
		int b1 = distance[v2];
		Arrays.fill(distance, Integer.MAX_VALUE);
		dijk(v1);
		int a2 = distance[v2];
		int b2 = distance[N];
		Arrays.fill(distance, Integer.MAX_VALUE);
		dijk(v2);
		int a3 = distance[v1];
		int b3 = distance[N];
		
		min = Math.min(min, a1 + a2 + b3);
		min = Math.min(min, b1 + a3 + b2);

		if ((a1 == Integer.MAX_VALUE || a2 == Integer.MAX_VALUE || b3 == Integer.MAX_VALUE)
			&& (b1 == Integer.MAX_VALUE || a3 == Integer.MAX_VALUE || b2 == Integer.MAX_VALUE))
			min = -1;
		System.out.println(min);
	}

	public static void dijk(int s) {
		PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
		q.add(new int[] {s, 0});
		distance[s] = 0;
		
		while (!q.isEmpty()) {
			int[] c = q.poll();

			if (c[1] > distance[c[0]])
				continue;

			for (int[] n : list[c[0]]) {
				int cost = c[1] + n[1];
				if (cost < distance[n[0]]) {
					distance[n[0]] = cost;
					q.add(new int[]{n[0], cost});
				}
			}
		}
	}
}
