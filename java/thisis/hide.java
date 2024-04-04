package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class hide {
	static List<Integer>[] list;
	static int[] distance;
	static int INF = 100000;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		list = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}

		distance = new int[N + 1];
		Arrays.fill(distance, INF);
		dijkstra(1);

		int idx = 0;
		int count = 0;
		int max = 0;
		for (int i = 1; i <= N; i++) {
			if (max < distance[i]) {
				max = distance[i];
				idx = i;
				count = 1;
			} else if (max == distance[i]) {
				count++;
			}
		}
		System.out.println(idx + " " + max + " " + count);
	}

	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		distance[start] = 0;

		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int c = node.n;
			int dis = node.d;
			if (distance[c] < dis)
				continue;
			for (int n : list[c]) {
				int d = dis + 1;
				if (distance[n] > d) {
					distance[n] = d;
					pq.add(new Node(n, d));
				}
			}
		}
	}

	static class Node implements Comparable<Node>{
		int n;
		int d;

		public Node(int n, int d) {
			this.n = n;
			this.d = d;
		}

		@Override
		public int compareTo(Node node) {
			return Integer.compare(this.d, node.d);
		}
	}
}
