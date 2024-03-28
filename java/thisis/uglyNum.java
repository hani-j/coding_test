package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class uglyNum {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[1001];
		arr[1] = 1;
		for (int i = 2; i < 1001; i += 2) {
			arr[i] = i;
		}
		for (int i = 3; i < 1001; i += 3) {
			arr[i] = i;
		}
		for (int i = 5; i < 1001; i += 5) {
			arr[i] = i;
		}

		int num = 0;
		int idx = 1;
		for (int i = 1; i < 1001; i++) {
			if (arr[i] != 0) {
				num++;
				if (num == N) {
					idx = i;
					break;
				}
			}
		}
		System.out.println(arr[idx]);
	}
}
