package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// greedy 02
public class multi {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split("");
		int[] nArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			nArr[i] = Integer.parseInt(arr[i]);
		}

		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			if (result == 0 || nArr[i] == 0)
				result += nArr[i];
			else
				result *= nArr[i];
		}
		System.out.println(result);
	}
}
