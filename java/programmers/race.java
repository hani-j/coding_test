package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class race {
	static public int solution(int[][] board) {
        int len = board.length;
        
        int[][][] map = new int[len][len][4];
		for (int[][] c : map) {
			for (int[] c2 : c) {
				Arrays.fill(c2, Integer.MAX_VALUE);
			}
		}

		int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0, -1));
        
        while (!q.isEmpty()) {
            Node n = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];
                if (nx >= 0 && nx < len && ny >= 0 && ny < len && board[nx][ny] == 0) {
					int nc = n.c + (n.dir == i || n.dir == -1 ? 100 : 600);
					if (nc < map[nx][ny][i]) {
						map[nx][ny][i] = nc;
						q.add(new Node(nx, ny, nc, i));
					}
                }
            }
        }

        return Arrays.stream(map[len - 1][len - 1]).min().orElseThrow();
    }
    
    static class Node {
        int x;
        int y;
		int c;
		int dir;
        
        public Node(int x, int y, int c, int dir) {
            this.x = x;
            this.y = y;
			this.c = c;
			this.dir = dir;
        }
    }

	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
		System.out.println(solution(board));
	}
}
