package thisis;

import java.util.ArrayList;
import java.util.List;

public class checkWallAns {
	public static int solution(int n, int[] weak, int[] dist) {
        int length = weak.length;
		int[] newWeak = new int[weak.length * 2];
        for (int i = 0; i < length; i++) {
			newWeak[i] = weak[i];
            newWeak[i + length] = weak[i] + n;
        }

        int answer = dist.length + 1;
        for (int start = 0; start < length; start++) {
            List<List<Integer>> permutations = generatePermutations(dist);
            for (List<Integer> friends : permutations) {
                int count = 1;
                int position = newWeak[start] + friends.get(count - 1);
                for (int index = start; index < start + length; index++) {
                    if (position < newWeak[index]) {
                        count++;
                        if (count > dist.length) {
                            break;
                        }
                        position = newWeak[index] + friends.get(count - 1);
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

    private static List<List<Integer>> generatePermutations(int[] dist) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[dist.length];
        backtrack(dist, used, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] dist, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == dist.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < dist.length; i++) {
            if (!used[i]) {
                used[i] = true;
                current.add(dist[i]);
                backtrack(dist, used, current, result);
                used[i] = false;
                current.remove(current.size() - 1);
            }
        }
    }

	public static void main(String[] args) {
		// int n = 12;
		// int[] weak = {1, 5, 6, 10};
		// int[] dist = {1, 2, 3, 4};

		// int n = 12;
		// int[] weak = {1, 3, 4, 9, 10};
		// int[] dist = {3, 5, 7};

		// int n = 50;
		// int[] weak = {1};
		// int[] dist = {6};

		int n = 30;
		int[] weak = {0, 3, 11, 21};
		int[] dist = {10, 4};

		System.out.println(solution(n, weak, dist));
	}

	// 다른 방법
	// class Solution {
	// 	int N = 0;
	// 	int ans = Integer.MAX_VALUE;

	// 	public int solution(int n, int[] weak, int[] dist) {
	// 		java.util.Arrays.sort(dist);
	// 		for (int i = 0; i < dist.length / 2; i++) {
	// 			int temp = dist[i];
	// 			dist[i] = dist[dist.length - 1 - i];
	// 			dist[dist.length - 1 - i] = temp;
	// 		}

	// 		this.N = n;
	// 		int min = Integer.MAX_VALUE;
	// 		dfs(0, weak, dist, 0);

	// 		return ans == Integer.MAX_VALUE ? -1 : ans;
	// 	}

	// 	private void dfs(int d, int[] weak, int[] dist, int visited) {
	// 		if (visited == ((1 << weak.length) - 1)) {
	// 			ans = Math.min(ans, d);
	// 			return;
	// 		}
	// 		if (d == dist.length) {
	// 			return;
	// 		}

	// 		for (int i = 0; i < weak.length; i++) {
	// 			if ((visited & (1 << i)) > 0) {
	// 				continue;
	// 			}
	// 			java.util.Set<Integer> set = new java.util.HashSet<>();
	// 			for (int j = 0; j < weak.length; j++) {
	// 				int k = (i + j) >= weak.length ? i + j - weak.length : i + j;
	// 				if ((visited & (1 << k)) > 0) {
	// 					continue;
	// 				}
	// 				int diff = weak[k] - weak[i];
	// 				if (diff < 0) {
	// 					diff += N;
	// 				}
	// 				if (diff <= dist[d]) {
	// 					set.add(k);
	// 					visited = visited | (1 << k);
	// 				} else {
	// 					break;
	// 				}
	// 			}
	// 			dfs(d+1, weak, dist, visited);
	// 			for (int v : set) {
	// 				visited = visited & ~(1 << v);
	// 			}
	// 		}
	// 	}
	// }
}
