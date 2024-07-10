package programmers;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class stones {
	static public int solution(int[] stones, int k) {
        int[] arr = new int[stones.length - k + 1];
        Deque<Integer> d = new LinkedList<>();

        for (int i = 0; i < stones.length; i++) {
            if (!d.isEmpty() && d.peekFirst() < i - k + 1)
                d.pollFirst();
            while  (!d.isEmpty() && stones[d.peekLast()] < stones[i])
                d.pollLast();
            d.offerLast(i);
            
            if (i - k >= -1)
                arr[i - k + 1] = stones[d.peekFirst()];
        }
        return Arrays.stream(arr).min().orElseThrow();
    }

	public static void main(String[] args) {
		int stones[] = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		int k = 3;
		
		System.out.println(solution(stones, k));
	}
}
