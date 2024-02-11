package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 09-02 dijkstra
public class telegram {
	static List<Node>[] list;
	static int[] distance;
	static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		distance = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
			distance[i] = INF;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			list[x].add(new Node(z, y));
		}

		dijkstra(C);
		int count = 0;
		int max = 0;
		for (int i = 1; i <= N; i++) {
			if (distance[i] != INF) {
				count ++;
				max = Math.max(max, distance[i]);
			}
		}
		System.out.println(count - 1 + " " + max);
	}

	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, start));
		distance[start] = 0;

		while (!pq.isEmpty()) {
			Node c = pq.poll();
			int t = c.time;
			int n = c.n;

			if (t > distance[start])
				continue;
			for (Node node : list[n]) {
				int time = node.time + t;
				if (time < distance[node.n]) {
					distance[node.n] = time;
					pq.add(new Node(time, node.n));
				}
			}
		}
	}

	static class Node implements Comparable<Node>{
		int time;
		int n;

		Node(int t, int n) {
			this.time = t;
			this.n = n;
		}

		@Override
		public int compareTo(Node node) {
			if (this.time == node.time)
				return 1;
			return this.time - node.time;
		}
	}
}
