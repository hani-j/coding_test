package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Microwave {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int T = Integer.parseInt(br.readLine());

		int[] times = {300, 60, 10};
		int[] count = new int[3];

		for (int i = 0; i < 3; i++) {
			if (T / times[i] > 0) {
				count[i] += T / times[i];
				T %= times[i];
			}
		}
		if (T != 0) {
			System.out.println("-1");
			return;
		}
		for (int i = 0; i < 3; i++) {
			System.out.print(count[i] + " ");
		}
		System.out.println();
	}
}