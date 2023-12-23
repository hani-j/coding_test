package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 25-4 1541
public class lostBracket {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split("-");

		int sum = 0;
		for (int j = 0; j < str.length; j++) {
			String[] plus = str[j].split("\\+");
			int n = Integer.parseInt(plus[0]);
			for (int i = 1; i < plus.length; i++) {
				n += Integer.parseInt(plus[i]);
			}
			if (j == 0)
				sum += n;
			else
				sum -= n;
		}
		System.out.println(sum);
	}
}
