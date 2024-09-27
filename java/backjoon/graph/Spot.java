package backjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Spot {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[][] map = new String[M][N];
		int[][] count = new int[M][N];

		for (int i = 0; i < M; i++) {
			map[i] = br.readLine().split("");
			Arrays.fill(count[i], 10001);
		}
		
		PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
		q.add(new int[]{0, 0, 0});

		int[] dx = {0, 0, -1, 1};
		int[] dy = {1, -1, 0, 0};
		while (!q.isEmpty()) {
			int[] n = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = n[0] + dx[i];
				int ny = n[1] + dy[i];	
				if (nx >= 0 && nx < M && ny >= 0 && ny < N && count[nx][ny] == 10001) {
					if (map[nx][ny].equals("0")) {
						q.add(new int[]{nx, ny, n[2]});
						count[nx][ny] = n[2];
					}
					else {
						q.add(new int[]{nx, ny, n[2] + 1});
						count[nx][ny] = n[2] + 1;
					}
				}
			}
		}
		if (count[M - 1][N - 1] == 10001)
			System.out.println("0");
		else
			System.out.println(count[M - 1][N - 1]);
	}
}
