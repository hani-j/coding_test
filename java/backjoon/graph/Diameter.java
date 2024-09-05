package backjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Diameter {
	static int N;
	static List<int[]>[] l;
	static boolean[] visited;
	static int maxD = 0;
	static int maxN = 0;
	 public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		if (N == 1) {
			System.out.println("0");
			return;
		}

		l = new List[N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			l[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			l[a].add(new int[] {b, c});
			l[b].add(new int[] {a, c});
		}
		
		dfs(1, 0);
		maxD = 0;

		visited = new boolean[N + 1];
		dfs(maxN, 0);

		System.out.println(maxD);
	}

	public static void dfs(int s, int d) {
		visited[s] = true;

		if (d > maxD) {
			maxD = d;
			maxN = s;
		} 
		for (int[] n : l[s]) {
			if (!visited[n[0]])
				dfs(n[0], d+ n[1]);
		}
	}
}
