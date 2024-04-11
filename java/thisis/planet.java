package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class planet {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		List<Node> x = new ArrayList<>();
		List<Node> y = new ArrayList<>();
		List<Node> z = new ArrayList<>();
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int tx = Integer.parseInt(st.nextToken());
			int ty = Integer.parseInt(st.nextToken());
			int tz = Integer.parseInt(st.nextToken());
			x.add(new Node(tx, i));
			y.add(new Node(ty, i));
			z.add(new Node(tz, i));
		}

		x.sort(null);
		y.sort(null);
		z.sort(null);

		List<Edge> edges = new ArrayList<>();
		for (int i = 0; i < N - 1; i++) {
			edges.add(new Edge(x.get(i + 1).d - x.get(i).d, x.get(i).i, x.get(i + 1).i));
			edges.add(new Edge(y.get(i + 1).d - y.get(i).d, y.get(i).i, y.get(i + 1).i));
			edges.add(new Edge(z.get(i + 1).d - z.get(i).d, z.get(i).i, z.get(i + 1).i));
		}
		edges.sort(null);
		int result = 0;
		for (Edge edge : edges) {
			int c = edge.c;
			int a = edge.a;
			int b = edge.b;

			if (find_parent(parent, a) != find_parent(parent, b)) {
				union_parent(parent, a, b);
				result += c;
			}
		}
		System.out.println(result);
	}

	static public class Node implements Comparable<Node> {
		int d;
		int i;

		public Node(int d, int i) {
			this.d = d;
			this.i = i;
		}

		@Override
		public int compareTo(Node node) {
			return Integer.compare(d, node.d);
		}
	}

	static public class Edge implements Comparable<Edge> {
		int c;
		int a;
		int b;

		public Edge(int c, int a, int b) {
			this.c = c;
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Edge e) {
			return Integer.compare(this.c, e.c);
		}
	}

	static public int find_parent(int[] parent, int x) {
		if (parent[x] != x)
			parent[x] = find_parent(parent, parent[x]);
		return parent[x];
	}

	static public void union_parent(int[] parent, int a, int b) {
		a = find_parent(parent, a);
		b = find_parent(parent, b);
		if (a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}
}
