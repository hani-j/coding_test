package thisis;

import java.util.ArrayList;
import java.util.List;

// implementation 14
public class checkWall {
	public static int solution(int n, int[] weak, int[] dist) {
        int length = weak.length;
		int[] newWeak = new int[length * 2];
		for (int i = 0; i < length; i++) {
			newWeak[i] = weak[i];
			newWeak[i + length] = weak[i];
		}

		int answer = dist.length + 1;
		for (int i = 0; i < length; i++) {
			List<List<Integer>> permutations = generatePermutations(dist);
			for (List<Integer> friends : permutations) {
				int count = 1;
				int position = newWeak[i] + friends.get(count - 1);
				for (int j = i; j < i + length; j++) {
					if (position < newWeak[j]) {
						count++;
						if (count > dist.length) {
							break;
						}
						position = newWeak[j] + friends.get(count - 1);
					}
				}
				answer = Math.min(answer, count);
			}
		}
		if (answer > dist.length) {
			return -1;
		}
		return answer;
    }

	private static List<List<Integer>> generatePermutations(int[] list) {
		List<List<Integer>> result = new ArrayList<>();
		boolean[] used = new boolean[list.length];
		backtrack(list, used, new ArrayList<>(), result);
		return result;
	}

	private static void backtrack(int[] list, boolean[] used, List<Integer> current, List<List<Integer>> result) {
		if (current.size() == list.length) {
			result.add(new ArrayList<>(current));
			System.out.println();
			return;
		}

		for (int i = 0; i < list.length; i++) {
			if (!used[i]) {
				used[i] = true;
				current.add(list[i]);
				backtrack(list, used, current, result);
				used[i] = false;
				current.remove(current.size() - 1);
			}
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
