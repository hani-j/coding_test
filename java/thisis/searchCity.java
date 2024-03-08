package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class searchCity {
	static List<Integer>[] list;
	static List<Integer> result;
	static boolean[] visited;
	static int[] shortest; 
	static int K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		list = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[s].add(e);
		}

		shortest = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			shortest[i] = Integer.MAX_VALUE;
		}
		for (Integer n : list[X]) {
			visited = new boolean[N + 1];
			dfs(n, 1);
		}
		int count = 0;
		for (int i = 1; i <= N; i++) {
			if (shortest[i] == K) {
				System.out.println(i);
				count++;
			}
		}
		if (count == 0)
			System.out.println("-1");
	}

	private static void dfs(int n, int d) {
		shortest[n] = Math.min(shortest[n], d);
		if (d == K) {
			return;
		}
		visited[n] = true;
		for (int i : list[n]) {
			if (!visited[i]){
				dfs(i, d + 1);
			}
		}
		visited[n] = false;
	}
}
