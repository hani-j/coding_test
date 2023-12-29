package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 26-3 1780
public class numOfPaper {
	static int[][] arr;
	static int[] count = new int[3];
	static int[][] devide = {{1,1,}, {2,2,2}}; 

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		devide(0, 0, N);
		bw.write(count[0] + "\n" + count[1] + "\n" + count[2] + "\n");
		bw.flush();
		bw.close();
	}

	static public void devide(int x, int y, int n) {
		if (isSquare(x, y, n)) {
			return ;
		}
		devide(x, y, n/3);		
		devide(x, y + n/3, n/3);
		devide(x, y + 2*n/3, n/3);

		devide(x + n/3, y, n/3);
		devide(x + n/3, y + n/3, n/3);
		devide(x + n/3, y + 2*n/3, n/3);
		
		devide(x + 2*n/3, y, n/3);
		devide(x + 2*n/3, y + n/3 , n/3);
		devide(x + 2*n/3, y + 2*n/3, n/3);
	}

	static public boolean isSquare(int x, int y, int n) {
		int num = arr[x][y];
		for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				if (arr[i][j] != num)
					return false;
			}
		}
		count[arr[x][y] + 1]++;
		return true;
	}
}
