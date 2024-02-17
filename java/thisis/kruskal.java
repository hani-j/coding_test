package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// 10-00 Kruskal
public class kruskal {
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		parent = new int[V + 1];
		List<Node> edges = new ArrayList<>();

		int result = 0;

		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edges.add(new Node(a, b, c));
		}

		edges.sort(null);
		// edges.sort(Comparator.comparingInt(node -> node.c));
		for (Node n : edges) {
			int a = n.a;
			int b = n.b;
			int c = n.c;

			if (findParent(a) != findParent(b)) {
				unionParent(a, b);
				result += c;
			}
		}
		System.out.println(result);
	}

	private static int findParent(int x) {
		if (parent[x] != x)
			parent[x] = findParent(parent[x]);
		return parent[x];
	}

	private static void unionParent(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		if (a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}

	static class Node implements Comparable<Node>{
		int a;
		int b;
		int c;

		Node(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public int compareTo(Node n) {
			if (this.c == n.c)
				return c;
			return this.c - n.c;
		}
	}
}
