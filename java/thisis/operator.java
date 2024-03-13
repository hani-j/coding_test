package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class operator {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		List<Integer> op = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			int r = Integer.parseInt(st.nextToken());
			for (int j = 0; j < r; j++) {
				op.add(i);
			}
		}

		List<List<Integer>> list = generateCombi(op);
		int max = -1000000000;
		int min = 1000000000;
		for (List<Integer> l : list) {
			int sum = arr[0];
			for (int i = 0; i < N - 1; i++) {
				if (l.get(i) == 0) {
					sum += arr[i + 1];
				} else if (l.get(i) == 1) {
					sum -= arr[i + 1];
				} else if (l.get(i) == 2) {
					sum *= arr[i + 1];
				} else {
					sum /= arr[i + 1];
				}
			}
			if (sum > max)
				max = sum;
			if (sum < min)
				min = sum;
		}

		System.out.println(max);
		System.out.println(min);
	}

	private static List<List<Integer>> generateCombi(List<Integer> o) {
		List<List<Integer>> result = new ArrayList<>();
		boolean[] used = new boolean[o.size()];
		backtrack(o, used, new ArrayList<>(), result);
		return result;
	}

	private static void backtrack(List<Integer> o, boolean[] used, List<Integer> c, List<List<Integer>> result) {
		if (c.size() == o.size()) {
			result.add(new ArrayList<>(c));
			return;
		}

		for (int i = 0; i < o.size(); i++ ) {
			if (!used[i]) {
				used[i] = true;
				c.add(o.get(i));
				backtrack(o, used, c, result);
				used[i] = false;
				c.remove(c.size() - 1);
			}
		}
	}
}
