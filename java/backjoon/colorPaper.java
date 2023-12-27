package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 26-1 2630
public class colorPaper {
	static int[][] arr ;
	static int[] color = new int[2];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		devide(0, 0, N);


		System.out.println(color[0]);
		System.out.println(color[1]);
	}
	
	static public void devide(int s, int e, int n) {
		if (n < 1)
			return ;
		if (isSquare(s, e, n)) {
		} else {
			devide(s, e, n/2);
			devide(s + n/2, e, n/2);			
			devide(s, e + n/2, n/2);
			devide(s + n/2, e + n/2, n/2);
		}		
	} 

	static public boolean isSquare(int s, int e, int n) {
		int num = arr[s][e];
		for (int i = s; i < s + n; i++) {
			for (int j = e; j < e + n ; j++) {
				if (arr[i][j] != num)
					return false;
			}  
		}
		color[arr[s][e]]++;
		return true;
	}
}
