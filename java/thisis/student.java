package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

// 06-02
public class student {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		ArrayList<Node> arr = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr.add(new Node(st.nextToken(), Integer.parseInt(st.nextToken())));
		}

		arr.sort(new Comparator<Node>() {
			@Override
			public int compare(Node a, Node b) {
				if (a.score == b.score)
					return a.score;
				return a.score - b.score;
			}
		});

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(arr.get(i).name + " ");
		}
		System.out.println(sb.toString());
	}
	
	static class Node {
		String name;
		int score;

		Node(String name, int score) {
			this.name = name;
			this.score = score;
		}
	}
}
