package backjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Chicken {
	static int N;
	static int M;
	static int[][] map;
	static List<int[]> home;
	static List<int[]> chicken;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		home = new ArrayList<>();
		chicken = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = n;
				if (n == 2)
					chicken.add(new int[] {i, j});
				else if (n == 1)
					home.add(new int[] {i, j});
			}
		}
		select(0, 0, new ArrayList<>());
		System.out.println(min);
	}

	static void select(int s, int c, List<int[]> nc) {
		if (c == M) {
			min = Math.min(min, sum(nc));
			return ;
		}

		for (int i = s; i < chicken.size(); i++) {
			nc.add(chicken.get(i));
			select(i + 1, c + 1, nc);
			nc.remove(nc.size() - 1);
		}
	}

	static int sum(List<int[]> c) {
		int sum = 0;
		for (int[] nh : home) {
			int m = Integer.MAX_VALUE;
			for (int[] nc : c) {
				int d = Math.abs(nh[0] - nc[0]) + Math.abs(nh[1] - nc[1]);
				m = Math.min(m, d);
			}
			sum += m;
		}
		return sum;
	}
}
