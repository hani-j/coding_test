package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Merge {
	static int[] arr;
	static int[] tmp;
	static int K;
	static int result = 0;
	static int count = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		tmp = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		sort(0, N - 1);
		if (result == 0)
			System.out.println(-1);
		else
			System.out.println(result);
	}

	public static void sort(int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			sort(p, q);
			sort(q + 1, r);
			merge(p, q, r);
		}
	}

	public static void merge(int p, int q, int r) {
		int i = p;
		int j = q + 1;
		int t = 0;

		while (i <= q && j <= r) {
			if (arr[i] <= arr[j])
				tmp[t++] = arr[i++];
			else
				tmp[t++] = arr[j++];
		}

		while (i <= q)
			tmp[t++] = arr[i++];

		while (j <= r)
			tmp[t++] = arr[j++];

		i = p;
		t = 0;
		while (i <= r) {
			arr[i] = tmp[t++];
			count++;

			if (count == K)
				result = arr[i];
			i++;
		}
	}
}
