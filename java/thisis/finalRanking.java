package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class finalRanking {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] indegree = new int[n + 1];
			boolean[][] graph = new boolean[n + 1][n + 1];
			for (boolean[] g : graph) {
				Arrays.fill(g, false);
			}
			List<Integer> data = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				data.add(Integer.parseInt(st.nextToken()));
			}
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					graph[data.get(i)][data.get(j)] = true;
					indegree[data.get(j)]++;
				}
			}
	
			int m = Integer.parseInt(br.readLine());
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (graph[a][b]) {
					graph[a][b] = false;
					graph[b][a] = true;
					indegree[a]++;
					indegree[b]--;
				} else {
					graph[a][b] = true;
					graph[b][a] = false;
					indegree[a]--;
					indegree[b]++;
				}
			}

			List<Integer> result = new ArrayList<>();
			Queue<Integer> q = new LinkedList<>();
			for (int i = 1; i <= n; i++) {
				if (indegree[i] == 0)
					q.add(i);
			}

			boolean certain = true;
			boolean cycle = false;

			for (int i = 0; i < n; i++) {
				if (q.size() == 0) {
					cycle = true;
					break;
				}
				if (q.size() >= 2) {
					certain = false;
					break;
				}
				int now = q.poll();
				result.add(now);
				for (int j = 1; j <= n; j++) {
					if (graph[now][j]) {
						indegree[j]--;
						if (indegree[j] == 0)
							q.add(j);
					}
				}
			}

			if (cycle)
				System.out.println("IMPOSSIBLE");
			else if (!certain)
				System.out.println("?");
			else {
				for (int r : result)
					System.out.print(r + " ");
				System.out.println();
			}
		}
	}
}
