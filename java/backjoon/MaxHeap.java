package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxHeap {
	static int[] heap;
	static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		heap = new int[N + 1];
		Arrays.fill(heap, -1);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n > 0)
				add(n);
			else
				sb.append(remove() + "\n");
		}
		System.out.println(sb.toString());
	}

	public static void add(int n) {
		heap[++max] = n;
		int idx = max;
		while (idx > 1 && heap[idx / 2] < heap[idx]) {
			int tmp = heap[idx];
			heap[idx] = heap[idx / 2];
			heap[idx / 2] = tmp;
			idx /= 2;
		}
	}

	public static int remove() {
		int n = heap[1];
		if (max == 0)
			return 0;
		heap[1] = heap[max];
		heap[max--] = -1;

		int idx = 1;
		while (idx <= max) {
			int big = idx;
			if (idx * 2 <= max && heap[big] < heap[idx * 2])
				big = idx * 2;
			if (idx * 2 + 1 <= max && heap[big] < heap[idx * 2 + 1])
				big = idx * 2 + 1;

			if (big != idx) {
				int tmp = heap[idx];
				heap[idx] = heap[big];
				heap[big] = tmp;
				idx = big;
			} else
				break;
		}

		return n;
	}
}
