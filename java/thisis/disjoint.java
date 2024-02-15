package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 10-00 disjoint 서로소
public class disjoint {
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		parent = new int[V + 1];

		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			unionParent(a, b);
		}

		StringBuilder sb = new StringBuilder();
		sb.append("각 원소가 속한 집합: ");
		for (int i = 1; i <= V; i++) {
			sb.append(findParent(i));
			sb.append(" ");
		}
		sb.append("\n");

		sb.append("부모 테이블: ");
		for (int i = 1; i <= V; i++) {
			sb.append(parent[i]);
			sb.append(" ");
		}
		System.out.println(sb.toString());
	}

	private static int findParent(int x) {
		if (parent[x] != x) {
			parent[x] = findParent(parent[x]);
		}
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
}
