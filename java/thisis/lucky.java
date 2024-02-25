package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// implementation 07
public class lucky {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split("");
		int left = 0;
		int right = 0;

		for (int i = 0; i < arr.length / 2; i++) {
			left += Integer.parseInt(arr[i]);
		}
		for (int i = arr.length / 2; i < arr.length; i++) {
			right += Integer.parseInt(arr[i]);
		}
		if (left % 10 == 6 && right % 10 == 6)
			System.out.println("LUCKY");
		else
			System.out.println("READY");
	}
}
