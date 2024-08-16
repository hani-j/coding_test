package backjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class NM4 {
	static int N;
	static int M;
	static List<List<Integer>> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();

		dfs(new ArrayList<>(), 1);
		StringBuilder sb = new StringBuilder();
		for (List<Integer> l : list) {
			for (Integer n : l) {
				sb.append(n + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void dfs(List<Integer> l, int s){
		if (l.size() == M) {
			list.add(new ArrayList<>(l));
			return ;
		}
		for (int i = s; i <= N; i++) {
			if (l.size() == 0 || (l.size() > 0 && l.get(l.size() - 1) <= i)) {
				l.add(i);
				dfs(l, i);
				l.remove(l.size() - 1);
			}
		}
	}
}