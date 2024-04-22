package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class truck {
	static public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Node> queue = new LinkedList<>();
        int w = truck_weights[0];
        int time = 1;
        int idx = 1;
        queue.add(new Node(truck_weights[0], time));
        while (!queue.isEmpty() || idx < truck_weights.length) {
            time++;
            Node node = queue.peek();
            if (!queue.isEmpty() && node.t + bridge_length == time) {
                node = queue.poll();
                w -= node.w;
            }
            if (idx < truck_weights.length && truck_weights[idx] + w <= weight && queue.size() < bridge_length) {
                queue.add(new Node(truck_weights[idx], time));
                w += truck_weights[idx];
                idx++;
            }
            if (queue.isEmpty())
                return time;
        }
        return time;
    }
    
    static class Node {
        int w;
        int t;
        
        public Node(int w, int t) {
            this.w = w;
            this.t = t;
        }
    }

	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7, 4, 5, 6};
		
		System.out.println(solution(bridge_length, weight, truck_weights));
	}
}
