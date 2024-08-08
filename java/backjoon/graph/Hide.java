package backjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Hide {
	static int[] arr;
	static int N;
	static int K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[100001];
		Arrays.fill(arr, -1);
		arr[N] = 0;

		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);

		while (!queue.isEmpty()) {
			int current = queue.poll();
			
			int[] next = {current - 1, current + 1, current * 2};
            
            for (int n : next) {
                if (n >= 0 && n <= 100000 && arr[n] == -1) { 
                    arr[n] = arr[current] + 1;
                    queue.add(n);
                }
            }
		}
		System.out.println(arr[K]);
	}
}
