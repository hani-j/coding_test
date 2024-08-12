package backjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class FindParent {
	static int[] parent;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer>[] list = new List[N + 1];
		parent = new int[N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
			parent[i] = i;
		}

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[s].add(e);
			list[e].add(s);
		}

		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		visited[1] = true;
		while (!stack.isEmpty()) {
			int n = stack.pop();
			for (int i : list[n]) {
				if (!visited[i]) {
					parent[i] = n;
					visited[i] = true;
					stack.push(i);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= N; i++) {
			sb.append(parent[i]);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
