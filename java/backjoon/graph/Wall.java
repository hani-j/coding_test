package backjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Wall {
	static char[][] map;
	static int[][][] visited;
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++)
				map[i][j] = str.charAt(j);
		}

		int min = bfs(0, 0);
		if (min == -1)
			System.out.println(-1);
		else
			System.out.println(min);
	}

	public static int bfs(int x, int y) {
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};

		visited = new int[N][M][2];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{x, y, 0});
		visited[x][y][0] = 1;

		while (!q.isEmpty()) {
			int[] n = q.poll();
			int cx = n[0];
			int cy = n[1];
			int b = n[2];

			if (n[0] == N - 1 && n[1] == M - 1) {
				return visited[cx][cy][b];
			}

			for (int i = 0; i < 4; i++) {
				int nx = n[0] + dx[i];
				int ny = n[1] + dy[i];

				if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (map[nx][ny] == '0' && visited[nx][ny][b] == 0) {
                        q.add(new int[]{nx, ny, b});
                        visited[nx][ny][b] = visited[cx][cy][b] + 1;
                    }
                    else if (map[nx][ny] == '1' && b == 0 && visited[nx][ny][1] == 0) {
                        q.add(new int[]{nx, ny, 1});
                        visited[nx][ny][1] = visited[cx][cy][b] + 1;
                    }
				}
			}
		}
		return -1;
	}
}
