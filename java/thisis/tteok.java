package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 07-01
public class tteok {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		System.out.println(binarySearch(M));
	}

	public static int binarySearch(int n) {
		int s = 0;
		int e = arr[N - 1];
		while (s <= e) {
			int m = (s + e) / 2;
			int sum = sum(m);
			if (sum > n) {
				s = m + 1;
			} else if (sum < n) {
				e = m - 1;
			} else
				return m;
		}
		return s;
	}

	public static int sum(int n) {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += arr[i] - n > 0 ? arr[i] - n : 0;
		}
		return sum;
	}
}
