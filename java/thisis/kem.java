package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class kem {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		List<Node> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Node(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		list.sort(null);
		StringBuilder sb = new StringBuilder();
		for (Node l : list) {
			sb.append(l.name + "\n");
		}
		System.out.println(sb.toString());
	}

	static class Node implements Comparable<Node> {
		String name;
		int k;
		int e;
		int m;

		public Node(String name, int k, int e, int m) {
			this.name = name;
			this.k = k;
			this.e = e;
			this.m = m;
		}

		@Override
		public int compareTo(Node n) {
			if (this.k == n.k) {
				if (this.e == n.e) {
					if (this.m == n.m) {
						return this.name.compareTo(n.name);
					}
					return n.m - this.m;
				} else
					return this.e - n.e;
			}
			return n.k - this.k;
		}
	}
}
