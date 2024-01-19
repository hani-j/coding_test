package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class searchPartAns {
	static int[] arr;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int search = Integer.parseInt(st.nextToken());
			if (binarySearch(search))
				sb.append("yes ");
			else
				sb.append("no ");
		}
		System.out.println(sb.toString());
	}

	private static boolean binarySearch(int n) {
		int s = 0;
		int e = N - 1;
		while (s <= e) {
			int mid = (s + e) / 2;

			if (arr[mid] > n) {
				e = mid - 1;
			} else if (arr[mid] < n) {
				s = mid + 1;
			} else
				return true;
		}
		return false;
	}
}
