package backjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class DBFS {
	static List<Integer>[] list;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1];
		list = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[s].add(e);
			list[e].add(s);
		}
		for (int i = 1; i <= N; i++) {
			list[i].sort(null);
		}
		StringBuilder sb = new StringBuilder();
		dfs(sb, V);
		sb.append("\n");
		visited = new boolean[N + 1];
		bfs(sb, V);
		System.out.println(sb.toString());
	}

	public static void dfs(StringBuilder sb, int s) {
		if (visited[s])
			return ;
		visited[s] = true;
		sb.append(s + " ");
		for (Integer c : list[s]) {
			if (!visited[c])
				dfs(sb, c);
		}
	}

	public static void bfs(StringBuilder sb, int s) {
		Queue<Integer> q = new LinkedList<>();
		visited[s] = true;
		sb.append(s + " ");
		q.add(s);

		while (!q.isEmpty()) {
			int n = q.poll();
			for (Integer c : list[n]) {
				if (!visited[c]) {
					visited[c] = true;
					sb.append(c + " ");
					q.add(c);
				}
			}
		}
	}
}
