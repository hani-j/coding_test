package thisis;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 04-03
public class knignt {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] pos = str.split("");

		int x = Integer.parseInt(pos[1]);
		int y = pos[0].charAt(0) - 'a' + 1;
		
		int count = 0;
		if (y > 2) {
			if (x > 1)
				count++;
			if (x < 7)
				count++;
		} 
		if (y < 6) {
			if (x > 1)
				count++;
			if (x < 7)
				count++;
		} 
		if (x > 2) {
			if (y > 1)
				count++;
			if (y < 7)
				count++;
		} 
		if (x < 6) {
			if (y > 1)
				count++;
			if (y < 7)
				count++;
		}
		System.out.println(count);
	}
}
