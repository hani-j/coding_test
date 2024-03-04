package thisis;

import java.util.ArrayList;
import java.util.List;

// implementation 12
public class column {
	public static void main(String[] args) {
		int n = 5;
		// int[][] build_frame = {{1,0,0,1}, {1,1,1,1}, {2,1,0,1}, {2,2,1,1}, {5,0,0,1}, {5,1,0,1}, {4,2,1,1}, {3,2,1,1}};
		int[][] build_frame = {{0,0,0,1}, {2,0,0,1}, {4,0,0,1}, {0,1,1,1}, {1,1,1,1}, {2,1,1,1}, {3,1,1,1}, {2,0,0,0}, {1,1,1,0}, {2,2,0,1}};
		int[][] arr = new int[n + 1][n + 1];
		List<Node> list = new ArrayList<>();

		for (int i = 0; i < build_frame.length; i++) {
			int x = build_frame[i][0];
			int y = build_frame[i][1];
			int s = build_frame[i][2];
			int e = build_frame[i][3];

			if (e == 0) {
				if (list.removeIf(node -> node.x == x && node.y == y && node.s == s) && !isPossible(list)) {
					list.add(new Node(x, y, s));
				}
			} else {
				list.add(new Node(x, y, s));
				if (!isPossible(list))
					list.removeIf(node -> node.x == x && node.y == y && node.s == s);
			}
		}

		list.sort(null);
		int result[][] = new int[list.size()][3];
		int i = 0;
		for (Node node : list) {
			result[i][0] = node.x;
			result[i][1] = node.y;
			result[i][2] = node.s;
			i++;
		}
		for (int j = 0; j < list.size(); j++) {
			System.out.println("result " + j + " : " + result[j][0] + " " + result[j][1] + " " + result[j][2] + " ");
		}
		// return result;
	}

	static boolean isPossible(List<Node> list) {
		for (Node n : list) {
			int x = n.x;
			int y = n.y;
			int s = n.s;
			if (s == 0) {
				if (y == 0 || list.contains(new Node(x - 1, y, 1)) || list.contains(new Node(x, y - 1, 0)))
					continue;
				else
					return false;
			} else {
				if (list.contains(new Node(x, y - 1, 0)) || list.contains(new Node(x + 1, y - 1, 0)) || (list.contains(new Node(x - 1, y, 1)) && list.contains(new Node(x + 1, y, 1))))
					continue;
				else
					return false;
			}
		}
		return true;
	}

	static class Node implements Comparable<Node> {
		int x;
		int y;
		int s;

		public Node(int x, int y, int s) {
			this.x = x;
			this.y = y;
			this.s = s;
		}

		@Override
		public int compareTo(Node node) {
			if (this.x == node.x)
				return this.y - node.y;
			return this.x - node.x;
		}

		@Override
		public boolean equals(Object obj) {
			Node othNode = (Node)obj;
			if (this.x == othNode.x && this.y == othNode.y && this.s == othNode.s)
				return true;
			return false;
		}
	}
}
