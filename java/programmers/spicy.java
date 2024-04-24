package programmers;

import java.util.PriorityQueue;

public class spicy {
	static public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            queue.add(scoville[i]);
        }
        int scov = scoville[0];
        while (!queue.isEmpty()) {
            int a = queue.poll();
            if (a >= K)
                break;
            if (queue.isEmpty())
                return -1;
            int b = queue.poll();
            scov = a + b * 2;
            queue.add(scov);
            answer++;
        }
        if (scov < K)
            return -1;
        return answer;
    }

	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		System.out.println(solution(scoville, K));
	}
}
