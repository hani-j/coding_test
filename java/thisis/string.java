package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// greedy 03
public class string {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split("");
		
		int count = 1;
		String tmp = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (!arr[i].equals(tmp)) {
				tmp = arr[i];
				count++;
			}
		}
		System.out.println(count / 2);
	}
}
