package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Camping {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int idx = 1;

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			if (L == 0 && P == 0 && V == 0)
				break;
			
			int c = V / P;
			int r = c * L;
			r += V % P <= L ? V % P : L;

			sb.append("Case ");
			sb.append(idx++);
			sb.append(": ");
			sb.append(r);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
