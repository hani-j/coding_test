package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 05-01
public class drink {
	static int[][] arr;
	static int N;
	static int M;
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}

		int count = 0;
		for (int i = 0; i < N; i ++) {
			for (int j = 0; j < M; j++) {
				if (DFS(i, j) == true)
					count++;
			}
		}
		System.out.println(count);
	}
	
	private static boolean DFS(int x, int y) {
		if (x < 0 || x >= N || y < 0 || y >= M) {
			return false;
		}
		if (arr[x][y] == 0) {
			arr[x][y] = 1;
			DFS(x - 1, y);
			DFS(x, y - 1);
			DFS(x + 1, y);
			DFS(x, y + 1);
			return true;
		}
		return false;
	}
}
