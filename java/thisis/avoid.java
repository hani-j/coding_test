package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class avoid {
	static String[][] arr;
	static String[][] tmp;
	static int N;
	static boolean result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		arr = new String[N][N];
		tmp = new String[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = st.nextToken();
			}
		}
		dfs(0);
		if (result == false)
		System.out.println("NO");
		else
		System.out.println("YES");
	}
	
	private static boolean search() {
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (tmp[i][j].equals("T")) {
					for (int k = 0; k < 4; k++) {
						int nx = i;
						int ny = j;
						while (true) {
							if (nx >= N || nx < 0 || ny >= N || ny < 0)
								break;
							if (tmp[nx][ny].equals("O"))
								break;
							if (tmp[nx][ny].equals("S")) {
								return false;
							}
							nx += dx[k];
							ny += dy[k];
						}
					}
				}
			}
		}
		return true;
	}

	private static void dfs(int c) {

		if (result || c == 3) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					tmp[i][j] = arr[i][j];
				}
			}
			if (search() == true)
				result = true;
			return ;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j].equals("X")) {
					arr[i][j] = "O";
					c++;
					dfs(c);
					arr[i][j] = "X";
					c--;
				}
			}
		}
	}
}

// 5
// X S X X T
// T X S X X
// X X X X X
// X T X X X
// X X T X X
