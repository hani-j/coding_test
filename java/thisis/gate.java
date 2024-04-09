package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class gate {
	static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());

		parent = new int[G + 1];
		for (int i = 1; i <= G; i++) {
			parent[i] = i;
		}

		int result = 0;
		for (int i = 0; i < P; i++) {
			int g = Integer.parseInt(br.readLine());
			int data = find_parent(parent, g);
			if (data ==  0)
				break;
			union_parent(parent, data, data - 1);
			result++;
		}
		System.out.println(result);
	}

	static public int find_parent(int[] parent, int x) {
		if (parent[x] != x)
			parent[x] = find_parent(parent, parent[x]);
		return parent[x];
	}

	static public void union_parent(int[] parent, int a, int b) {
		a = find_parent(parent, a);
		b = find_parent(parent, b);
		if (a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}
}
