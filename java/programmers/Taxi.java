package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Taxi {
	static public int solution(int n, int s, int a, int b, int[][] fares) {
        List<Node>[] list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            list[i] = new ArrayList<>();
        
        for (int i = 0; i < fares.length; i++) {
            list[fares[i][0]].add(new Node(fares[i][1], fares[i][2]));
            list[fares[i][1]].add(new Node(fares[i][0], fares[i][2]));
        }
        
        int[] dS = dijkstra(n, list, s);
        int[] dA = dijkstra(n, list, a);
        int[] dB = dijkstra(n, list, b);

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, dS[i] + dA[i] + dB[i]);
        }
        
        return answer;
    }

    static public int[] dijkstra(int n, List<Node>[] list, int s) {
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(s, 0));
        distance[s] = 0;
        
        while (!queue.isEmpty()) {
            Node N = queue.poll();
            int Nn = N.n;
            int Nc = N.c;
            
            if (Nc > distance[Nn])
                continue;
            for (Node node : list[Nn]) {
                int cost = Nc + node.c;
                if (cost < distance[node.n]) {
                    distance[node.n] = cost;
                    queue.add(new Node(node.n, cost));
                }
            }
        }
        return distance;
    }
    
    static class Node implements Comparable<Node>{
        int n;
        int c;
        
        public Node(int n, int c) {
            this.n = n;
            this.c = c;
        }

        public int compareTo(Node node) {
            return this.c - node.c;
        }
    }

	public static void main(String[] args) {
        int n1 = 6;
        int s1 = 4;
        int a1 = 6;
        int b1 = 2;
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        System.out.println(solution(n1, s1, a1, b1, fares));
    }
}
