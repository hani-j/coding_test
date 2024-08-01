package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MinHeap {
	static int[] heap;
	static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		heap = new int[N + 1];
		Arrays.fill(heap, -1);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int X = Integer.parseInt(br.readLine());
			if (X == 0)
				sb.append(getMin() + "\n");
			else
				add(X);
		}
		System.out.println(sb.toString());
	}

	public static void add(int n) {
		int idx = ++max;
		heap[idx] = n;
		while (idx > 1 && heap[idx / 2] > heap[idx]) {
            int temp = heap[idx / 2];
            heap[idx / 2] = heap[idx];
            heap[idx] = temp;
            idx /= 2;
        }
	}

	public static int getMin() {
		int min = heap[1];
		if (min == -1)
			return 0;
		heap[1] = heap[max];
		heap[max] = -1;
		max--;
		
		int idx = 1;
		while (idx <= max) {
			int left = idx * 2;
			int right = idx * 2 + 1;
			int smallest = idx;

			if (left <= max && heap[left] < heap[smallest]) {
				smallest = left;
			}

			if (right <= max && heap[right] < heap[smallest]) {
				smallest = right;
			}

			if (smallest != idx) {
				int temp = heap[idx];
				heap[idx] = heap[smallest];
				heap[smallest] = temp;
				idx = smallest;
			} else {
				break;
			}
		}
		return min;
	}
}