package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// dijkstra 1238
public class party {
	static List<Node>[] list;
	static int[] distance;
	static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		distance = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
			distance[i] = INF;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			list[s].add(new Node(t, e));
		}
		dijkstra(X);
		int[] result = new int[N + 1];
		for (int i = 1; i <= N; i++)
			result[i] = distance[i];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				distance[j] = INF;
			}
			dijkstra(i);
			result[i] += distance[X];
		}
		System.out.println(Arrays.stream(result).max().getAsInt());
	}

	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, start));
		distance[start] = 0;

		while(!pq.isEmpty()) {
			Node c = pq.poll();
			int t = c.t;
			int n = c.n;

			if (t > distance[n])
				continue;
			for (Node node : list[n]) {
				int time = t + node.t;
				if (time < distance[node.n]) {
					distance[node.n] = time;
					pq.add(new Node(time, node.n));
				}
			}
		}
	}

	static class Node implements Comparable<Node> {
		int t;
		int n;

		Node(int t, int n) {
			this.t = t;
			this.n = n;
		}

		@Override
		public int compareTo(Node node) {
			if (this.t == node.t)
				return 1;
			return this.t - node.t;
		}
		
	}
}
