package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// greedy 5585
public class change {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = {500, 100, 50, 10, 5, 1};

		int change = 1000 - N;
		int count = 0;
		int i = 0;
		while(change > 0) {
			if (change / arr[i] != 0) {
				count += change / arr[i];
				change %= arr[i];
			}
			i++;
		}
		System.out.println(count);
	}
}
