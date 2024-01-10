package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 02-04
public class one {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int count = 0;
		while (N > 1) {
			if (N % K == 0) {
				N /= K;
			} else {
				N -= 1;
			}
			count++;
		}
		System.out.println(count);
	}
}
