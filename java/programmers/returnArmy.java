package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class returnArmy {
    static int INF = Integer.MAX_VALUE;
    
    static public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
       
		List<Integer>[] l = new ArrayList[n + 1];
		int[] d = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			l[i] = new ArrayList<>();
			d[i] = INF;
		}
		
		for (int i = 0; i < roads.length; i++) {
			l[roads[i][0]].add(roads[i][1]);
			l[roads[i][1]].add(roads[i][0]);
		}

		dijk(l, d, destination);

        for (int i = 0; i < sources.length; i++) {
			if (d[sources[i]] == INF)
				answer[i] = -1;
			else
            	answer[i] = d[sources[i]];
        }
        
        return answer;
    }
    
    static public void dijk (List<Integer>[] l, int[] d, int s) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(s, 0));
        d[s] = 0;
        
        while (!queue.isEmpty()) {
            Node N = queue.poll();
            int n = N.n;
            int c = N.c;
            
            if (c > d[n])
                continue;
            for (Integer i : l[n]) {
                if (c + 1 < d[i]) {
                    d[i] = c + 1;
                    queue.add(new Node(i, c + 1));
                }
            }
        }
    }
    
    static class Node implements Comparable<Node>{
        int n;
        int c;
        
        public Node (int n, int c) {
            this.n = n;
            this.c = c;
        }
        
        public int compareTo(Node node) {
            return this.c - node.c;
        }
    }

	public static void main(String[] args) {
		int n1 = 3;
		int[][] roads1 = {{1, 2}, {2, 3}};
		int[] sources1 = {2, 3};
		int destination1 = 1;
		int[] result1 = solution(n1, roads1, sources1, destination1);
		System.out.println(Arrays.toString(result1));

		int n2 = 3;
		int[][] roads2 = {{1, 2}, {1, 4}, {2, 4}, {2, 5}, {4, 5}};
		int[] sources2 = {2, 3};
		int destination2 = 2;
		int[] result2 = solution(n2, roads2, sources2, destination2);
		System.out.println(Arrays.toString(result2));

	}
}
