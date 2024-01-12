package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 04-02
public class time {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int hour = 0;
		int count = 0;

		while (hour <= N) {
			if (hour % 10 == 3) {
				count += 60 * 60;
				hour++;
				continue;
			}
			for (int i = 0; i < 60; i++) {
				for (int j = 0; j < 60; j++) {
					if (i % 10 == 3 || j % 10 == 3 || (i >= 30 && i < 40) || (j >= 30 && j < 40)) {
						count++;
					}
				}
			}
			hour++;
		}
		System.out.println(count);
	}
}
