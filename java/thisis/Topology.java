package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 10-00 Topology Sort 위상 정렬
public class Topology {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		int[] indegree = new int[V + 1];
		List<Integer>[] graph = new ArrayList[V + 1];		
		for (int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			indegree[b]++;
		}

		List<Integer> result = new ArrayList<>();
		Queue<Integer> deque = new LinkedList<>();

		for (int i = 1; i <= V; i++) {
			if (indegree[i] == 0) {
				deque.add(i);
			}
		}

		while (!deque.isEmpty()) {
			int now = deque.poll();
			result.add(now);

			for (int n : graph[now]) {
				indegree[n]--;
				if (indegree[n] == 0)
					deque.add(n);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i : result)
			sb.append(i + " ");
		
		System.out.println(sb.toString());
	}
}
