package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 04-04
public class game {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		map[x][y] = 2;
		int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
		int[][] back = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
		int count = 0;
		while(true) {
			int nx;
			int ny;
			boolean move = false;

			for (int i = 0; i < 4; i++) {
				nx = x + dir[c][0];
				ny = y + dir[c][1];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
					x = nx;
					y = ny;
					map[nx][ny] = 2;
					move = true;
					count++;
					c = c > 0 ? c - 1 : 3;
					break;
				} else {
					c = c > 0 ? c - 1 : 3; 
				}
			}
			if (move == false) {
				nx = x + back[c][0];
				ny = y + back[c][1];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 2) {
					x = nx;
					y = ny;
					count++;
				} else
					break;
			}
		}
		System.out.println(count);
	}
}
