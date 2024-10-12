package backjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Kinship {
	static List<Integer>[] l;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());

		l = new List[N + 1];
		for (int i = 1; i <= N; i++)
			l[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			l[x].add(y);
			l[y].add(x);
		}
	
		System.out.println(count(A, B));
	}

	public static int count(int a, int b) {
		int[] visited = new int[N + 1];
		Queue<Integer> q = new LinkedList<>();
		visited[a] = 1;
		q.add(a);

		while (!q.isEmpty()) {
			int n = q.poll();
			if (n == b)
				return visited[n] - 1;
			for (int i : l[n]) {
				if (visited[i] == 0) {
					visited[i] = visited[n] + 1;
					q.add(i);
				}
			}
		}
		return -1;
	}
}
