package backjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Snake {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());	
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[11][10];
		for (int i = 0; i <= 10; i++) {
			for (int j = 0; j < 10; j++) {
				map[i][j] = i * 10 + j;
			}
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x / 10][x % 10] = y;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			map[u / 10][u % 10] = v;
		}

		int[][] visited = new int[11][11];
		for (int[] v : visited)
			Arrays.fill(v, Integer.MAX_VALUE);

		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited[0][1] = 0;

		while (!q. isEmpty()) {
			int n = q.poll();
			for (int i = 1; i <= 6; i++) {
				int cn = n + i;
				int num = map[cn / 10][cn % 10];
				if (num <= 100 && visited[n / 10][n % 10] + 1 < visited[num / 10][num % 10]) {
					visited[num / 10][num % 10] = visited[n / 10][n % 10] + 1;
					q.add(num);
				}
			}
		}
		System.out.println(visited[10][0]);
	}
}