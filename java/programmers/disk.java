package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class disk {
	static public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Node> q = new PriorityQueue<>();
        
        int time = 0;
        int idx = 0;
        int count = 0;
        while (count < jobs.length) {
            while (idx < jobs.length && jobs[idx][0] <= time) {
                q.add(new Node(jobs[idx][0], jobs[idx++][1]));
            }
            
            if (!q.isEmpty()) {
                Node n = q.poll();
                time += n.t;
                answer += time - n.s;
                count++;
            } else {
                time = jobs[idx][0];     
            }      
        }
        return answer / jobs.length;
    }
    
    static class Node implements Comparable<Node> {
        int s;
        int t;
        
        public Node(int s, int t) {
            this.s = s;
            this.t = t;
        }
        
        public int compareTo(Node n) {
            return Integer.compare(this.t, n.t);
        }
    }

	public static void main(String[] args) {
		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
		System.out.println(solution(jobs));
	}
}
