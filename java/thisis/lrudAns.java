package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class lrudAns {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = 1, y = 1;
		int[] dx = {0, 0, -1, 1};
		int[] dy = {-1, 1, 0, 0};
		String[] md = {"L", "R", "U", "D"};
		for (int i = 0; i < 6; i++) {
			String dir = st.nextToken();
			
			for (int j = 0; j < 4; j++) {
				if (md[j].equals(dir)) {
					int nx = x + dx[j];
					int ny = y + dy[j];
					
					if (nx < 1 || ny < 1 || nx > N || ny > N) 
						continue;
					x = nx;
					y = ny;
				}
			}
		}
		System.out.println(x + " " + y);
	}
}
