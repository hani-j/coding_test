package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class card {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			q.add(Integer.parseInt(br.readLine()));
		}
		int sum = 0;
		while (!q.isEmpty()) {
			if (q.size() == 1)
				break;
			int num = q.poll() + q.poll();
			sum += num;
			q.add(num);
		}
		System.out.println(sum);
	}
}
