package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BigNum {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] count = new int[1000001];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			count[arr[i]]++;
		}

		int[] result = new int[N];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			while (!stack.isEmpty() && count[arr[stack.peek()]] < count[arr[i]])
				result[stack.pop()] = arr[i];
			stack.push(i);
		}

		while (!stack.isEmpty())
			result[stack.pop()] = -1;

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++)
			sb.append(result[i]).append(" ");
		System.out.println(sb);
	}
}
