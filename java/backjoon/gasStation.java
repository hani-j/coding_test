package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 25-5 
public class gasStation {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		List<Integer> distance = new ArrayList<>();
		List<Integer> price = new ArrayList<>();

		for (int i = 0; i < N - 1; i++) {
			distance.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++) {
			price.add(Integer.parseInt(st.nextToken()));
		}

		int sum = 0;
		for (int i = 0; i < N - 1; i++) {
			sum += distance.get(i);
		}

		System.out.println(sum);
	}
}