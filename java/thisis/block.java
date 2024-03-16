package thisis;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class block {
	public static void main(String[] args) {
		int[][] board = {{0,0,0,1,1}, {0,0,0,1,0}, {0,1,0,1,1},{1,1,0,0,1},{0,0,0,0,0}};
		System.out.println(solution(board));
	}

	public static int solution(int[][] board) {
		int len = board.length;
		int[][] newBoard = new int[len + 2][len + 2];
		for (int i = 0; i < newBoard.length; i++) {
			for (int j = 0; j < newBoard[i].length; j++) {
				newBoard[i][j] = 1;
			}
		}
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				newBoard[i + 1][j + 1] = board[i][j];
			}
		}
		Queue<Data> queue = new LinkedList<>();
		List<Node> visited = new ArrayList<>();
		Node newNode = new Node(1, 1, 1, 2);
		queue.add(new Data(newNode, 0));
		visited.add(newNode);
		while (!queue.isEmpty()) {
			Data d = queue.poll();
			Node n = d.node;
			int c = d.cost;

			if ((n.x1 == len && n.y1 == len) || (n.x2 == len && n.y2 == len))
				return c;
			List<Node> node = getNext(n, newBoard);
			for (Node N : node) {
				if (!visited.contains(N)) {
					queue.add(new Data(N, c + 1));
					visited.add(N);
				}
			}
		}
		return 0;
    }

	public static List<Node> getNext(Node pos, int[][] board) {
		List<Node> next = new ArrayList<>();
		int x1 = pos.x1;
		int y1 = pos.y1;
		int x2 = pos.x2;
		int y2 = pos.y2;

		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};

		for (int i = 0; i < 4; i++) {
			int nx1 = x1 + dx[i], ny1 = y1 + dy[i], nx2 = x2 + dx[i], ny2 = y2 + dy[i];
			if (board[nx1][ny1] == 0 && board[nx2][ny2] == 0)
				next.add(new Node(nx1, ny1, nx2, ny2));
		}
		if (x1 == x2) {
			for (int i = -1; i < 2; i += 2) {
				if (board[x1 + i][y1] == 0 && board[x2 + i][y2] == 0) {
					next.add(new Node(x1, y1, x1 + i, y1));
					next.add(new Node(x2, y2, x2 + i, y2));
				}
			}
		} else if (y1 == y2) {
			for (int i = -1; i < 2; i += 2) {
				if (board[x1][y1 + i] == 0 && board[x2][y2 + i] == 0) {
					next.add(new Node(x1, y1, x1, y1 + i));
					next.add(new Node(x2, y2, x2, y2 + i));
				}
			}
		}
		return next;
	}

	static class Node {
		int x1;
		int y1;
		int x2;
		int y2;

		public Node(int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}
	}

	static class Data {
		Node node;
		int cost;

		public Data(Node node, int cost) {
			this.node = node;
			this.cost = cost;
		}
	}
}
