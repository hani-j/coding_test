package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class practice {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] d = new int[100];
		d[0] = arr[0];
		d[1] =  arr[0] > arr[1] ? arr[0] : arr[1];
		for (int i = 2; i < N; i++) {
			d[i] = d[i - 1] > arr[i] + d[i-2] ? d[i - 1] : arr[i] + d[i-2] ;
		}
		System.out.println(d[N - 1]);
	}
}
