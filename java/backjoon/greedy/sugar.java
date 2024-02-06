package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2839
public class sugar {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int count = 0;
		int n = N;
		if (n / 5 > 0) {
			if (n % 5 == 0) {
				count += n / 5;
				n %= 5;
			}
			int five = n / 5;
			while (five > 0) {
				int num =  n - five * 5;
				if (num % 3 == 0) {
					count = five + num / 3;
					n = 0;
				}
				five--;
			}
		}
		if (n / 3 > 0) {
			if (n % 3 == 0) {
				count = n / 3;
				n %= 3;
			}
		}
		if (n != 0)	
			System.out.println("-1");
		else
			System.out.println(count);
	}
}
