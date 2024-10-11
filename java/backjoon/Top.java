package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Top {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] result = new int[N + 1];

		Stack<int[]> stack = new Stack<>();
		for (int i = N; i > 0; i--) {
			if (!stack.isEmpty()) {
				int[] n = stack.peek();
 				while (!stack.isEmpty() && arr[i] > n[1]) {
					int[] c = stack.pop();
					result[c[0]] = i;
					if (!stack.isEmpty())
						n = stack.peek();
				}
				stack.push(new int[] {i, arr[i]});
			}
			else
				stack.push(new int[] {i, arr[i]});
		}
		while (!stack.isEmpty()) {
			int[] c = stack.pop();
			result[c[0]] = 0;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(result[i]);
			sb.append(" ");
		}
		System.out.println(sb);
	}
}