package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AB {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int count = 0;

		while (B > A) {
			if (B % 10 == 1 && B / 10 >= A) {
				B /= 10;
				count++;
			} else if (B % 2 == 0 && B / 2 >= A) {
				B /= 2;
				count++;
			} else {
				System.out.println("-1");
				return ;
			}
		}
		System.out.println(count + 1);
	}
}
