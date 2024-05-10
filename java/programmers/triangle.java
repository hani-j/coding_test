package programmers;

public class triangle {
	static public int solution(int[][] triangle) {
        int answer = 0;
        int[][] map = new int[triangle.length][triangle.length];
        map[0][0] = triangle[0][0];
        int[] dx = {1, 1};
        int[] dy = {0, 1};
        int l = 1;
        
        for (int i = 0; i < triangle.length - 1; i++) {
            for (int j = 0; j < l; j++) {
                int lx = i + dx[0];
                int ly = j + dy[0];
                map[lx][ly] = Math.max(map[lx][ly], map[i][j] + triangle[lx][ly]);
                
                int rx = i + dx[1];
                int ry = j + dy[1];
                map[rx][ry] = Math.max(map[rx][ry], map[i][j] + triangle[rx][ry]);
            }
            l++;
        }
        
        for (int i = 0; i < triangle.length; i++) {
            answer = Math.max(answer, map[triangle.length - 1][i]);    
        }
        return answer;
    }

	public static void main(String[] args) {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		System.out.println(solution(triangle));
	}
}
