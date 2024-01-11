package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 04-01
public class lrud {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = 1;
		int y = 1;
		for (int i = 0; i < 6; i++) {
			String dir = st.nextToken();
			switch (dir) {
				case "L":
					if (y > 1)
						y--;
					break;
				case "R":
					if (y < N)
						y++;
					break;
				case "U":
					if (x > 1)
						x--;
					break;
				case "D":
					if (x < N)
						x++;
					break;
				default:
					break;
			}
		}
		System.out.println(x + " " + y);
	}
}
