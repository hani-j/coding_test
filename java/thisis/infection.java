package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class infection {
	static int[][] arr;
	static Queue<Node>	queue;
	static int S;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		List<Node> l = new ArrayList<>();
		queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] != 0)
					l.add(new Node(arr[i][j], 0, i, j));
			}
		}
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());

		l.sort(null);
		queue.addAll(l);

		bfs();
		if (arr[X - 1][Y - 1] == 0)
			System.out.println(0);
		else
			System.out.println(arr[X - 1][Y - 1]);
	}

	private static void bfs() {
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};

		while (!queue.isEmpty()) {
			Node n = queue.poll();
			if (n.s == S)
				break;
			for (int i = 0; i < 4; i++) {
				int nx = n.x + dx[i];
				int ny = n.y + dy[i];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if (arr[nx][ny] == 0) {
						arr[nx][ny] = n.k;
						queue.add(new Node(n.k, n.s + 1, nx, ny));
					}
				}
			}
		}
	}

	static class Node implements Comparable<Node> {
		int k;
		int s;
		int x;
		int y;

		public Node(int k, int s, int x, int y) {
			this.k = k;
			this.s = s;
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Node o) {
			if (this.k == o.k)
				return 1;
			return this.k - o.k;
		}
	}
}
