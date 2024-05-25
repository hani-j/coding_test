package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class item {
	static public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] board = new int[101][101];
        for (int[] r : rectangle) {
            for (int i = r[0] * 2; i <= r[2] * 2; i++) {
                for (int j = r[1] * 2; j <= r[3] * 2; j++) {
                    board[i][j] = 1;
                }
            }
        }
        
        for (int[] r : rectangle) {
            for (int i = r[0] * 2 + 1; i < r[2] * 2; i++) {
                for (int j = r[1] * 2 + 1; j < r[3] * 2; j++) {
                    board[i][j] = 0;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[101][101];
        
        q.add(new int[]{characterX * 2, characterY * 2, 0});
        visited[characterX * 2][characterY * 2] = true;
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        while (!q.isEmpty()) {
            int[] c = q.poll();
            int cx = c[0];
            int cy = c[1];
            int dist = c[2];
            
            if (cx == itemX * 2 && cy == itemY * 2) {
                return dist / 2;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if (nx >= 0 && ny >= 0 && nx <= 100 && ny <= 100 && board[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, dist + 1});
                }
            }
        }
        
        return -1;
    }

	public static void main(String[] args) {
		int[][] rectangle = {{1,1,7,4}, {3,2,5,5}, {4,3,6,9}, {2,6,8,8}};
		int characterX = 1;
		int characterY = 3;
		int itemX = 7;
		int itemY = 8;

		System.out.println(solution(rectangle, characterX, characterY, itemX, itemY));
	}
}
