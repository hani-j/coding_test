package programmers;

public class way {
	static public int solution(int m, int n, int[][] puddles) {
        int NUM = 1000000007;
        int[][] tables = new int[n + 1][m + 1];
        if (puddles[0].length > 0) {
            for (int[] p : puddles) {
                tables[p[1]][p[0]] = -1;
            }
        }
        
        tables[0][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (tables[i][j] == -1)
                    continue;
                if (tables[i][j - 1] == -1 && tables[i - 1][j] == -1)
                    continue;
                else if (tables[i - 1][j] == -1)
                    tables[i][j] = tables[i][j - 1] % NUM;
                else if (tables[i][j - 1] == -1)
                    tables[i][j] = tables[i - 1][j] % NUM;
                else
                    tables[i][j] = (tables[i][j - 1] + tables[i - 1][j]) % NUM;
            }
        }
        return tables[n][m];
    }

	public static void main(String[] args) {
		int m = 4;
		int n = 3;
		int[][] puddles = {{2, 2}};
		System.out.println(solution(m, n, puddles));
	}
}
