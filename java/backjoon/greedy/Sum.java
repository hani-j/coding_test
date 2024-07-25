package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sum {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());

		long n = 1;
		int count = 0;
		long result = 0;
		while (true) {
			result += n++;
			count++;
			if (result == N)
				break;
			else if (result > N) {
				count--;
				break;
			}
		}

	    System.out.println(count);

	}
}
