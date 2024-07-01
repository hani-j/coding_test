package programmers;

import java.util.Collections;
import java.util.PriorityQueue;

public class overtime {
	static public long solution(int n, int[] works) {
        long answer = 0;
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < works.length; i++)
            queue.add(works[i]);
        
        while (!queue.isEmpty() && n > 0) {
            int w = queue.poll();
            if (w > 1)
                queue.add(w - 1);
            n--;
        }
        while (!queue.isEmpty()) {
            int num = queue.poll();
            answer += num * num;
        }
        return answer;
    }

	public static void main(String[] args) {
		int[] works1 = {4, 3, 3};
		int n1 = 4;
		System.out.println(solution(n1, works1));

		int[] works2 = {1, 1};
		int n2 = 3;
		System.out.println(solution(n2, works2));
	}
}
