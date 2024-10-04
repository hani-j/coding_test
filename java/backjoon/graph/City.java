package backjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class City {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		List<Integer>[] l = new List[N + 1];
		for (int i = 1; i <= N; i++)
			l[i] = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			l[A].add(B);
		}
		
		List<Integer> result = new ArrayList<>();
		int[] visited = new int[N + 1];
		Arrays.fill(visited, -1);
		Queue<Integer> q = new LinkedList<>();
		q.add(X);
		visited[X] = 0;
		while (!q.isEmpty()) {
			int c = q.poll();
			for (int n : l[c]) {
				if (visited[n] == -1) {
					visited[n] = visited[c] + 1;
					q.add(n);
					if (visited[n] == K)
						result.add(n);
				}
			}
		}
		if (result.isEmpty()) {
			System.out.println(-1);
			return ;
		}
		result.sort(null);
		StringBuilder sb = new StringBuilder();
		for (int n : result) {
			sb.append(n);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
}