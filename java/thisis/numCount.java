package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class numCount {
	static int[] arr;
	static int N;
	static int x;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		find(0, N - 1);
		if (N == 1 && arr[0] == x)
			count = 1;
		if (count == 0)
			System.out.println("-1");
		else
			System.out.println(count);
	}

	public static void find(int s, int e) {
		if (s == e)
			return ;
		int mid = (s + e) / 2;
		
		if (arr[mid] == x) {
			if (mid != 0 && arr[mid - 1] == x)
				find(s, mid);
			else {
				count++;
				mid++;
				while (mid < N && arr[mid] == x) {
					count++;
					mid++;
				}
			}
		} else if (arr[mid] > x)
			find(s, mid);
		else
			find(mid + 1, e);
	}
}
