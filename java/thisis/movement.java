package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class movement {
	static int[][] arr;
	static boolean[][] visited;
	static int N;
	static int L;
	static int R;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int count = 0;
		while (true) {
			visited = new boolean[N][N];
			if (move())
				count++;
			else
				break;
		}
		System.out.println(count);
	}

	private static boolean move() {
		boolean result = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (bfs(i, j))
					result = true;
			}
		}
		return result;
	}

	private static boolean bfs(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		List<Node> list = new ArrayList<>();
		queue.add(new Node(x, y, arr[x][y]));
		visited[x][y] = true;

		int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

		while (!queue.isEmpty()) {
			Node n = queue.poll();
			list.add(n);
			for (int i = 0; i < 4; i++) {
				int nx = n.x + dx[i];
				int ny = n.y + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
					int diff = Math.abs(arr[nx][ny] - arr[n.x][n.y]);
					if (diff >= L && diff <= R) {
						queue.add(new Node(nx, ny, arr[nx][ny]));
						visited[nx][ny] = true;
					}
				}
			}
		}
		if (list.size() > 1) {
			int all = 0;
			for (Node n : list) {
				all += n.p;
			}
			int devide = all / list.size();
			for (Node n : list) {
				arr[n.x][n.y] = devide;
			}
			return true;
		}
		return false;
	}

	static class Node {
		int x;
		int y;
		int p;

		public Node(int x, int y, int p) {
			this.x = x;
			this.y = y;
			this.p = p;
		}
	}
}
