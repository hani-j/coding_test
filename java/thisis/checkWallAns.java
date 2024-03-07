package thisis;

import java.util.ArrayList;
import java.util.List;

public class checkWallAns {
	public static int solution(int n, int[] weak, int[] dist) {
		int length = weak.length;
		int[] newWeak = new int[length * 2];
		List<Integer> newDist = new ArrayList<>();
		for (int i = 0; i < dist.length; i++) {
			newDist.add(dist[i]);
		}
		for (int i = 0; i < length; i++) {
			newWeak[i] = weak[i];
		}
		for (int i = 0; i < length; i++) {
			newWeak[i + length] = weak[i] + n;
		}
		int answer = dist.length + 1;

		for (int i = 0; i < length; i++) {
			List<List<Integer>> l = generateCombi(newDist, dist.length);
			for (List<Integer> d : l) {
				int count = 1;
				int position = newWeak[i] + d.get(count - 1);
				for (int j = i; j < i + length; j++) {
					if (position < newWeak[j]) {
						count++;
						if (count > dist.length)
							break;
						position = newWeak[j] + d.get(count - 1);
					}
				}
				answer = Math.min(answer, count);
			}
		}
		if (answer > dist.length)
			return -1;
		return answer;
	}

	private static <T> List<List<T>> generateCombi(List<T> e, int n) {
		List<List<T>> result = new ArrayList<>();
		backtrack(e, 0, new ArrayList<>(), result, n);
		return result;
	}

	private static <T> void backtrack(List<T> e, int s, List<T> c, List<List<T>> result, int n) {
		if (c.size() == n) {
			result.add(new ArrayList<>(c));
			return;
		}

		for (int i = s; i < e.size(); i++) {
			c.add(e.get(i));
			backtrack(e, i + 1, c, result, n);
			c.remove(c.size() - 1);
		}
	}

	public static void main(String[] args) {
		int n = 12;
		int[] weak = {1, 5, 6, 10};
		int[] dist = {1, 2, 3, 4};

		// int n = 12;
		// int[] weak = {1, 3, 4, 9, 10};
		// int[] dist = {3, 5, 7};

		// int n = 50;
		// int[] weak = {1};
		// int[] dist = {6};

		// int n = 30;
		// int[] weak = {0, 3, 11, 21};
		// int[] dist = {10, 4};

		System.out.println(solution(n, weak, dist));
	}
}
