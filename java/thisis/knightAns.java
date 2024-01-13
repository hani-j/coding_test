package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class knightAns {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split("");
		
		int x = Integer.parseInt(str[1]);
		int y = str[0].charAt(0) - 'a' + 1;

		int[][] steps = {{-2, -1}, {-2, 1}, {2, 1}, {2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};

		int count = 0;
		for (int[] step : steps) {
			int nx = x + step[0];
			int ny = y + step[1];
			if (nx >= 1 && nx <= 8 && ny >= 1 && ny <= 8)
				count++; 
		}
		System.out.println(count);
	}
}
