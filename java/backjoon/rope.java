package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// greedy 2217
public class rope {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		} 

		Arrays.sort(arr);
		int max = arr[N - 1];
		int count = 1;
		for (int i = N - 2; i >= 0; i--) {
			count++;
			int w = arr[i] * count;
			if (max < w) {
				max = w;
			}
		}
		System.out.println(max);
	}
}
