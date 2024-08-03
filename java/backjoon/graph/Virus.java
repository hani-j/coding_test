package backjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Virus {
	static List<Integer>[] list;
	static boolean[] visited;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		list = new List[N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[s].add(e);
			list[e].add(s);
		}
		dfs(1);
		System.out.println(count - 1);
	}
	
	public static void dfs(int s) {
		visited[s] = true;
		count++;
		for (Integer n : list[s]) {
			if (!visited[n])
				 dfs(n);
		}
	}
}
