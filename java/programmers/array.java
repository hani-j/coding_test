package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class array {
	static public int[] solution(int n, long left, long right) {
        List<Long> list = new ArrayList<>();
        for (long i = left; i <= right; i++) {
            long s = i / n + 1;
            long r = i % n + 1;
            if (r < s + 1)
                list.add(s);
            else
                list.add(r);
        }
        return list.stream().mapToInt(Long::intValue).toArray();
    }

	public static void main(String[] args) {
		int n = 3;
		int left = 2;
		int right = 5;

		int[] result = solution(n, left, right);
		System.out.println(Arrays.toString(result));
	}
}
