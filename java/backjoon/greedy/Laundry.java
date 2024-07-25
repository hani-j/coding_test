package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Laundry {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] money = {25, 10, 5, 1};
		int T = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			for (int j = 0; j < 4; j++) {
				if (n / money[j] > 0) {
					sb.append((int) n / money[j] + " ");
					n %= money[j];
				} else
					sb.append("0 ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
