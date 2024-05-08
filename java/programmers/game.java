package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class game {
	static int[][] ms;
	static int[][] tables;
    static int[][] visited;

    static public int solution(int[][] maps) {
        int INF = 100000;
        tables = new int[maps.length][maps[0].length];
        visited = new int[maps.length][maps[0].length];
        for (int i = 0; i < maps.length; i++) {
            Arrays.fill(tables[i], INF);
        }
        ms = maps;
        bfs(0, 0);
        if (tables[maps.length - 1][maps[0].length - 1] == INF)
            return -1;
        return tables[maps.length - 1][maps[0].length - 1];
    }
    
    static public void bfs(int x, int y) {
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};
        Queue<Node> queue = new LinkedList<>();
        tables[x][y] = 1;
		visited[x][y] = 1;
        queue.add(new Node(x, y));
        
        while(!queue.isEmpty()) {
            Node c = queue.poll();
            for (int i = 0; i < 4; i++) {
                int cx = c.x + dx[i];
                int cy = c.y + dy[i];
                if (cx < ms.length && cx >= 0 && cy >= 0 && cy < ms[0].length) {
                    if (ms[cx][cy] == 1 && visited[cx][cy] == 0) {
						visited[cx][cy] = 1;
						tables[cx][cy] = Math.min(tables[cx][cy], tables[c.x][c.y] + 1);
                        queue.add(new Node(cx, cy));
                    }
                }
            }
        }
    }
    
    static class Node {
        int x;
        int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

	public static void main(String[] args) {
		int[][] maps = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}};
		System.out.println(solution(maps));
	}
}
