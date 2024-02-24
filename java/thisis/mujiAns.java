package thisis;

import java.util.Arrays;
import java.util.PriorityQueue;

public class mujiAns {
	public static void main(String[] args) {
		int[] food_times = {1, 10, 10};
		int k = 6;

		if (Arrays.stream(food_times).sum() <= k) {
			System.out.println("-1");
			return ;
		}
		
		PriorityQueue<Node> q = new PriorityQueue<>();
		for (int i = 0; i < food_times.length; i++) {
			q.add(new Node(food_times[i], i + 1));
		}

		int sum = 0;
		int pre = 0;
		int length = food_times.length;

		while (sum + (q.peek().t - pre) * length <= k) {
			Node now = q.poll();
			sum += (now.t - pre) * length;
			length--;
			pre = now.t;
		}

		Node[] r = new Node[q.size()];
		q.toArray(r);
		Arrays.sort(r, (n1, n2) -> Integer.compare(n1.n, n2.n));
		System.out.println(r[(k - sum) % length].n);
	}

	static class Node implements Comparable<Node>{
		int t;
		int n;

		Node(int t, int n) {
			this.t = t;
			this.n = n;
		}

		@Override
		public int compareTo(Node node) {
			return Integer.compare(this.t, node.t);
		}
	}
}
