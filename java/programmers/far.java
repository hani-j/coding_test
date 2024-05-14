package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class far {
	static List<Node>[] graph;
    static int[] distance;
    
    static public int solution(int n, int[][] edge) {
        int answer = 0;
        int INF = Integer.MAX_VALUE;
        
        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        distance = new int[n + 1];
        Arrays.fill(distance, INF);
        for (int i = 0; i < edge.length; i++) {
            graph[edge[i][0]].add(new Node(edge[i][1], 1));
            graph[edge[i][1]].add(new Node(edge[i][0], 1));
        }
        
        bfs(1);
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] > max)
                max = distance[i];
        }
        for (int i = 1; i <= n; i++) {
            if (distance[i] == max)
                answer++;
        }
        return answer;
    }
    
    static public void bfs(int s) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(s, 0));
        distance[s] = 0;
        
        while(!q.isEmpty()) {
            Node c = q.poll();
            int cn = c.n;
            int cc = c.c;
            
            if (cc > distance[cn]) {
                continue;
            }
            
            for (Node n : graph[cn]) {
                int nc = cc + n.c;
                if (nc < distance[n.n]) {
                    distance[n.n] = nc;
                    q.add(new Node(n.n, nc));
                }
            }
        }
    }
    
    static class Node implements Comparable<Node>{
        int n;
        int c;
        
        public Node(int n, int c) {
            this.n = n;
            this.c = c;
        }
        
        public int compareTo(Node node) {
            return Integer.compare(this.c, node.c);
        }
    }

	public static void main(String[] args) {
		int n = 6;
		int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		System.out.println(solution(n, vertex));
	}
}
