package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class resignation {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		List<Node> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			list.add(new Node(t, p));
		}
		int[] d = new int[N + 1];
		int max = 0;
		for (int i = N - 1; i >= 0; i--) {
			Node n = list.get(i);
			int t = n.t + i;
			if (t <= N) {
				d[i] = Math.max(n.p + d[t], max);
				max = d[i];
			} else
				d[i] = max;
		}
		System.out.println(max);
	}

	static class Node {
		int t;
		int p;

		public Node(int t, int p) {
			this.t = t;
			this.p = p;
		}
	}
}
