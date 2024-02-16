package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 10-00 disjoint cycle 판별
public class cycle {
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		parent = new int[V + 1];
		for (int i = 1; i <= V; i++)
			parent[i] = i;
		
		boolean cycle = false;

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (findParent(a) == findParent(b)) {
				cycle = true;
				break;
			} else {
				unionParent(a, b);
			}
		}
		if (cycle)
			System.out.println("사이클 발생");
		else
			System.out.println("사이틀 발생하지 않음");
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
