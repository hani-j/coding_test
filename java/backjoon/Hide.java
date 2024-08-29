package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Hide {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] graph = new int[100001];
		Arrays.fill(graph, Integer.MAX_VALUE);
		graph[N] = 0;

		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		
		while (!q.isEmpty()) {
			int p = q.poll();

			if (p + 1 < 100001 && graph[p + 1] > graph[p] + 1) {
                graph[p + 1] = graph[p] + 1;
                q.add(p + 1);
            }
            if (p - 1 >= 0 && graph[p - 1] > graph[p] + 1) {
                graph[p - 1] = graph[p] + 1;
                q.add(p - 1);
            }
            if (p * 2 < 100001 && graph[p * 2] > graph[p]) {
                graph[p * 2] = graph[p];
                q.add(p * 2);
            }
		}

		// PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
		// q.add(new int[]{N, 0});
		// while (!q.isEmpty()) {
		// 	int[] n = q.poll();
		// 	int p = n[0];
		// 	int t = n[1];
			
		// 	if (p + 1 < 100001 && t + 1 < graph[p + 1]) {
		// 		graph[p + 1] = t + 1;
		// 		q.add(new int[]{p + 1, t + 1});
		// 	}
		// 	if (p == 0)
		// 		continue;
		// 	if (p - 1 >= 0 && t + 1 < graph[p - 1]) {
		// 		graph[p - 1] = t + 1;
		// 		q.add(new int[]{p - 1, t + 1});
		// 	}
		// 	for (int i = p; i < 100001; i *= 2) {
		// 		if (t < graph[i]) {
		// 			graph[i] = t;
		// 			q.add(new int[] {i, t});
		// 		}
		// 	}
		// }

		System.out.println(graph[K]);
	}
}
