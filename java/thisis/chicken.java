package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// implementation 13
public class chicken {

	static List<Node> map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

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
		List<List<Node>> list = generateCombi(chiMap, M);
		int result = 1000;
		for (List<Node> l : list) {
			result = Math.min(result, getSum(l));
		}
		System.out.println(result);
	}

	private static <T> List<List<T>> generateCombi(List<T> e, int n) {
		List<List<T>> result = new ArrayList<>();
		backtrack(e, 0, new ArrayList<>(), result, n);
		return result;
	}

	private static <T> void backtrack(List<T> e, int s, List<T> c, List<List<T>> result, int n) {
		if (c.size() == n) {
			result.add(new ArrayList<>(c));
			return;
		}

		for (int i = s; i < e.size(); i++) {
			c.add(e.get(i));
			backtrack(e, i + 1, c, result, n);
			c.remove(c.size() - 1);
		}
	}

	private static int getSum(List<Node> chiPosition) {
		int sum = 0;
		for (Node n : map) {
			int tmp = 1000;
			for (Node ch : chiPosition) {
				tmp = Math.min(tmp, Math.abs(n.r - ch.r) + Math.abs(n.c - ch.c));
			}
			sum += tmp;
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
