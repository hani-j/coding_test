package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class travel {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < N; i++) {
			String[] arr = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				if (arr[j].equals("1"))
					union_parent(parent, i + 1, j + 1);
			}
		}

		int[] plan = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			plan[i] = Integer.parseInt(st.nextToken());
		}
		boolean result = true;
		for (int i = 0; i < M - 1; i++) {
			if (find_parent(parent, plan[i]) != find_parent(parent, plan[i + 1]))
				result = false;
		}
		if (result)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

	public static int find_parent(int[] parent, int x) {
		if (parent[x] != x)
			parent[x] = find_parent(parent, parent[x]);
		return parent[x];
	}

	public static void union_parent(int[] parent, int a, int b) {
		a = find_parent(parent, a);
		b = find_parent(parent, b);
		if (a < b)
			parent[b] = a;
		else 
			parent[a] = b;
	}
}
