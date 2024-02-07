package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// dijkstra 1916
public class minCost {
	static List<Node>[] arr;
	static int distance[];
	static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		arr = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		distance = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			distance[i] = INF;
		}
		StringTokenizer st;
		for (int i = 0; i < M; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[a].add(new Node(c, b));
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		dijkstra(start);
		System.out.println(distance[end]);
	}

	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(0, start));
		distance[start] = 0;
		
		while (!pq.isEmpty()) {
			Node N = pq.poll();
			int c = N.cost;
			int n = N.n;

			if (c > distance[n])
				continue;

			for (Node node : arr[n]) {
				int cost = c + node.cost;
				if (cost < distance[node.n]) {
					distance[node.n] = cost;
					pq.add(new Node(cost, node.n));
				}
			}
		}
	}

	static class Node implements Comparable<Node>{
		int cost;
		int n;

		Node(int cost, int n) {
			this.cost = cost;
			this.n = n;
		}

		@Override
		public int compareTo(Node node) {
			if (this.cost == node.cost)
				return 1;
			return this.cost - node.cost;
		}
	}
}
