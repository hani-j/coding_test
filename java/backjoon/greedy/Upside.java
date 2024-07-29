package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Upside {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int[] num = new int[2];
		char c = str.charAt(0);
		num[c - '0']++;
		for (int i = 1; i < str.length(); i++) {
			char n = str.charAt(i);
			if (n != c) {
				num[n - '0']++;
				c = n;
			}
		}

		int result = num[0] > num[1] ? num[1] : num[0];
		System.out.println(result);
	}
}
