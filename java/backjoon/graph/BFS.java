package backjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		List<Integer>[] list = new List[N + 1];
		for (int i = 0; i <= N; i++)
			list[i] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}

		for (List<Integer> l : list)
			l.sort(null);

		Queue<Integer> q = new LinkedList<>();
		q.add(R);
		int[] visited = new int[N + 1];
		int count = 1;
		visited[R] = count++;
		while (!q.isEmpty()) {
			int n = q.poll();
			for (Integer c : list[n]) {
				if (visited[c] == 0) {
					visited[c] = count++;
					q.add(c);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(visited[i]);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
