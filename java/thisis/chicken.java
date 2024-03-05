package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import backjoon.primeNumber;

// implementation 13
public class chicken {

	static List<Node> map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// int[][] map = new int[N + 1][N + 1];
		map = new ArrayList<>();
		List<Node> chiMap = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int w = Integer.parseInt(st.nextToken());
				if (w == 1)
					map.add(new Node(i, j));
				else if (w == 2)
					chiMap.add(new Node(i, j));
			}
		}
		// List<List<Node> list = generateCombi(chiMap);
		// List<Integer> result = new ArrayList<>();
		// for (Node n : chiMap) {
		// 	System.out.println("chicken r : " + n.r + " c : " + n.c);
		// 	result.add(getDistance(map, n));
		// }
		// result.sort(null);
		// System.out.println(result.get(0));
	}

	private static <T> List<List<T>> generateCombi(List<T> e) {
		List<List<T>> result = new ArrayList<>();
		backtrack(e, 0, new ArrayList<>(), result);
		return result;
	}

	private static <T> void backtrack(List<T> e, int s, List<T> c, List<List<T>> result) {
		result.add(new ArrayList<>(c));

		for (int i = s; i < e.size(); i++) {
			c.add(e.get(i));
			backtrack(e, i + 1, c, result);
			c.remove(c.size() - 1);
		}
	}

	private static int getSum(List<Node> map, Node chiPosition) {
		int sum = 0;
		for (Node n : map) {
			sum += Math.abs(n.r - chiPosition.r) + Math.abs(n.c - chiPosition.c);
			System.out.println((n.r - chiPosition.r) + " " + (n.c - chiPosition.c) + " sum : " + sum);
		}
		return sum;
	}

	static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}
