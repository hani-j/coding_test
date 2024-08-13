package backjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class NM1 {
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();

		List<List<Integer>> list = makeList();
		for (List<Integer> l : list)
			sb.append(l.stream().map(String::valueOf).collect(Collectors.joining(" ")) + "\n");
		System.out.println(sb.toString());
	}

	public static List<List<Integer>> makeList() {
		List<List<Integer>> list = new ArrayList<>();
		boolean[] used = new boolean[N + 1];
		backTrack(list, used, new ArrayList<>());
		return list;
	}

	public static void backTrack(List<List<Integer>> list, boolean[] used, List<Integer> c) {
		if (c.size() == M) {
			list.add(new ArrayList<>(c));
			return;
		}
			
		for (int i = 1; i <= N; i++) {
			if (!used[i]) {
				used[i] = true;
				c.add(i);
				backTrack(list, used, c);
				used[i] = false;
				c.remove(c.size() - 1);
			}
		}
	}

	// static void dfs(int depth) {
    //     if (depth == M) {
    //         for (int num : arr) {
    //             sb.append(num).append(" ");
    //         }
    //         sb.append("\n");
    //         return;
    //     }

    //     for (int i = 0; i < N; i++) {
    //         if (!visited[i]) {
    //             visited[i] = true;
    //             arr[depth] = i + 1;
    //             dfs(depth + 1);
    //             visited[i] = false;
    //         }
    //     }
    // }
}
