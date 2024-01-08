package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// greedy 2839
public class sugarDelivery {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		System.out.println(getMin(N));
	}

	private static int getMin(int n) {
		int count = 0;
		if (n / 5 > 0) {
			if (n % 5 == 0) {
				return (count + n / 5);
			}
			int five = n / 5;
			while (five > 0) {
				int num =  n - five * 5;
				if (num % 3 == 0) {
					return (five + num / 3);
				}
				five--;
			}
		}
		if (n / 3 > 0) {
			if (n % 3 == 0) {
				return n / 3;
			}
		}
		return -1;
	}
}
