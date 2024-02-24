package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bowlingAns {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[10];
		for (int i = 0; i < N; i++) {
			arr[Integer.parseInt(st.nextToken())]++;
		}
		int result = 0;
		for (int i = 1; i <= M; i++) {
			N -= arr[i];
			result += arr[i] * N;
		}

		System.out.println(result);
	}
}
// 1 2 1 2 2
// 1 * 7 + 2 * 5 + 1 * 4 + 2 * 2
// 7 + 10 + 4 + 4