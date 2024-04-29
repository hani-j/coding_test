package programmers;

import java.util.HashSet;
import java.util.Set;

public class prime {
	static public int solution(String numbers) {
        Set<Integer> primeSet = new HashSet<>();
        String[] nums = numbers.split(""); 

        for (int i = 1; i <= nums.length; i++) {
            boolean[] visited = new boolean[nums.length];
            generateCombinations(nums, visited, new StringBuilder(), i, primeSet);
        }

        return primeSet.size();
    }

    static private void generateCombinations(String[] nums, boolean[] visited, StringBuilder sb, int length, Set<Integer> primeSet) {
        if (sb.length() == length) {
            int num = Integer.parseInt(sb.toString());
            if (isPrime(num)) {
                primeSet.add(num);
            }
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(nums[i]);
                generateCombinations(nums, visited, sb, length, primeSet);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }

    static private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }

        int sqrt = (int) Math.sqrt(num);
        for (int i = 3; i <= sqrt; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

	public static void main(String[] args) {
		// String numbers = "17";
		String numbers = "011";
		System.out.println(solution(numbers));
	}
}
