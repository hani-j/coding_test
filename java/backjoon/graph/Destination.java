package backjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Destination {
	static int n;
	static List<int[]>[] l;
	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			l = new List[n + 1];
			for (int i = 1; i <= n; i++)
				l[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				l[a].add(new int[]{b, d});
				l[b].add(new int[]{a, d});
			}
			int[] can = new int[t];
			for (int i = 0; i < t; i++)
				can[i] = Integer.parseInt(br.readLine());

			int[] distS = dijk(s);
			int[] distG = dijk(g);
			int[] distH = dijk(h);
			
			List<Integer> result = new ArrayList<>();
			for (int c : can) {
				int d = distS[c];
                int path1 = distS[g] + distG[h] + distH[c];
                int path2 = distS[h] + distH[g] + distG[c];

                if (d == path1 || d == path2) {
                    result.add(c);
                }
			}
			result.sort(null);
			for (int r : result)
				sb.append(r).append(" ");
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static public int[] dijk(int s) {
		PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
		int[] d = new int[n + 1];
		Arrays.fill(d, INF);
		d[s] = 0;
		q.add(new int[] {s, 0});

		while (!q.isEmpty()) {
			int[] N = q.poll();
			
			if (N[1] > d[N[0]])
				continue;
			for (int[] c : l[N[0]]) {
				if (d[N[0]] + c[1] < d[c[0]]) {
					d[c[0]] = d[N[0]] + c[1];
					q.add(new int[] {c[0], d[c[0]]});
				}
			}
		}
		return d;
	}
}
