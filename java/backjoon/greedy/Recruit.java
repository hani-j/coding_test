package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Recruit {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			List<int[]> l = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				l.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
			}
			l.sort((a, b) -> Integer.compare(a[0], b[0]));

			int count = 1;
			int min = l.get(0)[1];
			for (int[] n : l) {
				if (n[1] < min) {
					count++;
					min = n[1];
				}
			}
			sb.append(count);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
