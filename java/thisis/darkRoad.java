package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class darkRoad {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		List<Node> list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			list.add(new Node(x, y, z));
		}
		list.sort(null);

		int total = 0;
		int result = 0;
		for (Node node : list) {
			int x = node.x;
			int y = node.y;
			int z = node.z;
			total += z;
			if (find_parent(parent, x) != find_parent(parent, y)) {
				union_parent(parent, x, y);
				result += z;
			}
		}
		System.out.println(total - result);
	}

	private static int find_parent(int[] parent, int x) {
		if (parent[x] != x)
			parent[x] = find_parent(parent, parent[x]);
		return parent[x];
	}

	private static void union_parent(int[] parent, int a, int b) {
		a = find_parent(parent, a);
		b = find_parent(parent, b);
		if (a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}

	static class Node implements Comparable<Node>{
		int x;
		int y;
		int z;

		public Node (int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		@Override
		public int compareTo(Node n) {
			return Integer.compare(z, n.z);
		}
	}
}
