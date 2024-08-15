package backjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NM3 {
	static List<List<Integer>> list;
	static boolean[] visited;
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();
		visited = new boolean[N + 1];
		dfs(new ArrayList<>());
		StringBuilder sb = new StringBuilder();
		for (List<Integer> l : list) {
			for (Integer n : l) {
				sb.append(n + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void dfs(List<Integer> l) {
		if (l.size() == M) {
			list.add(new ArrayList<>(l));
			return ;
		}
		for (int i = 1; i <= N; i++) {
			l.add(i);
			dfs(l);
			l.remove(l.size() - 1);
		}
	}
}
