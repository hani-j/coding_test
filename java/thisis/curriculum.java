package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 10-03 topology
public class curriculum {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		List<Integer>[] graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		int[] time = new int[N + 1];
		int[] indegree = new int[N + 1];
		int[] result = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			result[i] = time[i];
			int num = Integer.parseInt(st.nextToken());
			if (num == -1)
				continue;
			graph[num].add(i);
			indegree[i]++;
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0)
				q.add(i);
		}
		
		while (!q.isEmpty()) {
			int now = q.poll();
			
			for (int n : graph[now]) {
				indegree[n]--;
				result[n] = Math.max(result[n], result[now] + time[n]);
				if (indegree[n] == 0)
					q.add(n);
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++)
			sb.append(result[i] + "\n");
		
		System.out.println(sb.toString());
	}
}
