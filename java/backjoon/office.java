package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// 25-2 1931
public class office {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		List<Node> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		list.sort(new Comparator<Node>() {
			@Override
			public int compare(Node S, Node E) {
				if (S.end == E.end) {
					return S.start - E.start; 
				}
				return S.end - E.end;
			}
		});
		int count = 0;
		int end = -1;
		for (int i = 0; i < N; i++) {
			if (list.get(i).start >= end) {
				end = list.get(i).end;
				count++;
			}
		}
		System.out.println(count);
	}

	static class Node {
		int start;
		int end;

		public Node(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}
