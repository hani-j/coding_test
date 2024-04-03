package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class mars {
	static int[][] graph;
	static int[][] distance;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int INF = 10001;
		StringBuilder sb = new StringBuilder();

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			graph = new int[N][N];
			distance = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(distance[i], INF);
			}
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dijkstra(0, 0);
			sb.append(distance[N - 1][N - 1] + "\n");
		}
		System.out.println(sb.toString());
	}

	static public void dijkstra(int x, int y) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(graph[x][y], x, y));
		distance[x][y] = graph[x][y];

		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};

		while (!pq.isEmpty()) {
			Node c = pq.poll();
			if (distance[c.x][c.y] < c.d)
				continue;
			for (int i = 0; i < 4; i++) {
				int nx = c.x + dx[i];
				int ny = c.y + dy[i];

				if (nx < 0 || nx >= graph.length || ny < 0 || ny >= graph.length)
					continue;
				int cost = c.d + graph[nx][ny];
				if (cost < distance[nx][ny]) {
					distance[nx][ny] = cost;
					pq.add(new Node(cost, nx, ny));
				}
			}
		}
		
	}

	static class Node implements Comparable<Node>{
		int d;
		int x;
		int y;

		public Node(int d, int x, int y) {
			this.d = d;
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.d, o.d);
		}
	}
}
