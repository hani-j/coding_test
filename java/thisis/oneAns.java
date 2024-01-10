package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class oneAns {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int count = 0;
		while (N > 1) {
			int target = (N / K) * K;
			count += N - target;
			N = target;
			if (N < K)
				break;
			N /= K;
			count++;
		}
		count += N - 1;
		System.out.println(count);
	}
}
