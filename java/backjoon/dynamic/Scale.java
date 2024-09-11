package backjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Scale {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] weight = new int[N];
		for (int i = 0; i < N; i++)
			weight[i] = Integer.parseInt(st.nextToken());

		int C = Integer.parseInt(br.readLine());
		int[] bead = new int[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++)
			bead[i] = Integer.parseInt(st.nextToken());

		Set<Integer> list = new HashSet<>();
		list.add(0);

		for (int i = 0; i < N; i++) {
			Set<Integer> l = new HashSet<>(list);
			for (int n : l) {
				list.add(n + weight[i]);
				list.add(Math.abs(n - weight[i]));
			}
		}
	
		StringBuilder sb = new StringBuilder();
		for (int b : bead) {
			if (list.contains(b))
				sb.append("Y ");
			else
				sb.append("N ");
		}
		System.out.println(sb);
	}
}
