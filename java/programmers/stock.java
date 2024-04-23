package programmers;

import java.util.PriorityQueue;

public class stock {
	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 2, 3};
		int[] answer = solution(prices);
		for (int num : answer) {
			System.out.print(num + " ");
		}
	}

	static public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(0, prices[0]));
        for (int i = 1; i < prices.length; i++) {
            int c = prices[i];
            queue.add(new Node(i, c));
            while (!queue.isEmpty() && queue.peek().p > c) {
                Node n = queue.poll();
                answer[n.i] = i - n.i;
            }
        }
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            answer[n.i] = prices.length - 1 - n.i;
        }
        return answer;
    }
    
    static class Node implements Comparable<Node>{
        int i;
        int p;
        
        public Node(int i, int p) {
            this.i = i;
            this.p = p;
        }
        
        public int compareTo(Node n) {
            return Integer.compare(n.p, p);
        }
    }
}
