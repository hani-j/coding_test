package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 08-02
public class antWorrior {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int sum = 0;
		int sum2 = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (i % 2 == 0) {
				sum2 += num;
			} else
				sum += num;
		}
		if (sum > sum2)
			System.out.println(sum);
		else
			System.out.println(sum2);
	}
}
