package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 08-03
public class floorAns {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] d = new int[1001];

		d[1] = 1;
		d[2] = 3;
		for (int i = 3; i <= N; i++) {
			d[i] = (d[i - 1] + 2 * d[i - 2]) % 796796;
		}
		System.out.println(d[N]);
	}
}
