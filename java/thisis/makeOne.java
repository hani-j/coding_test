package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 08-01
public class makeOne {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());

		int count = 0;
		while (X > 1) {
			System.out.println(X);
			int n = X % 5;
			if (X % 5 == 0) {
				X /= 5;
			} else if (X % 3 == 0) {
				X /= 3;
			} else if (n > 1 && X % 2 == 0) {
				X /= 2;
			} else {
				X--;
			}
			count++;
		}
		System.out.println(count);
	}
}
