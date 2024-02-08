package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// dijkstra 1753
public class shortest {
	static List<Node>[] arr;
	static int[] distance;
	static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		arr = new List[V + 1];
		for (int i = 1; i <= V; i++) {
			arr[i] = new ArrayList<>();
		}
		distance = new int[V + 1];
		Arrays.fill(distance, INF);

		int start = Integer.parseInt(br.readLine());
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[a].add(new Node(c, b));
		}

		dijkstra(start);

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			if (distance[i] != INF)
				sb.append(distance[i] + "\n");
			else
				sb.append("INF\n");
		}
		System.out.println(sb.toString());
	}

	static public void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, start));
		distance[start] = 0;

		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int c = node.cost;
			int n = node.n;

			if (c > distance[n])
				continue;
			for (Node i : arr[n]) {
				int cost = c + i.cost;
				if (cost < distance[i.n]) {
					distance[i.n] = cost;
					pq.add(new Node(cost, i.n));
				}
			}
		}
	}
	
	static class Node implements Comparable<Node>{
		int cost;
		int n;

		Node(int c, int n) {
			this.cost = c;
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
