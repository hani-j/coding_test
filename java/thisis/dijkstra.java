package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 09-00 dijkstra heap
public class dijkstra {
	static int[] distance;
	static List<Node>[] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		int INF = Integer.MAX_VALUE;

		graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

		distance = new int[N + 1];
        Arrays.fill(distance, INF);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new Node(b, c));
		}

		dijkstra(start);

		for (int i = 1; i <= N; i++) {
			if (distance[i] == INF) {
				System.out.println("INFINITY");
			}
			else {
				System.out.println(distance[i]);
			}
		}
	}

	static public void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentDir = current.dir;
            int currentCost = current.cost;

            if (currentCost > distance[currentDir]) {
                continue;
            }

			for (Node n : graph[currentDir]) {
				int c = currentCost + n.cost;
				if (c < distance[n.dir]) {
					distance[n.dir] = c;
					pq.add(new Node(n.dir, c));
				}
			}
		}
	}

	static class Node implements Comparable<Node>{
		int dir;
		int cost;

		Node(int d, int c) {
			this.dir = d;
			this.cost = c;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
}
