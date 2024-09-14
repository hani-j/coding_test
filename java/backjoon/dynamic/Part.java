package backjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Part {
	static int N;
	static int S;
	static int[] arr;
	static int C = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			make(0, i, new ArrayList<>());
		}
		System.out.println(C);
	}

	static void make(int s, int c, List<Integer> l) {
		if (l.size() == c) {
			sum(l);
			return ;
		}
		for (int i = s; i < N; i++) {
			l.add(arr[i]);
			make(i + 1, c, l);
			l.remove(l.size() - 1);
		}
	}

	static void sum(List<Integer> l) {
		int sum = 0;
		for (int n : l)
			sum += n;
		if (sum == S)
			C++;
	}

	// static void findSub(int idx, int sum) {
    //     if (idx == N) {
    //         if (sum == S) C++;
    //         return;
    //     }

    //     findSub(idx + 1, sum + arr[idx]);
    //     findSub(idx + 1, sum);
    // }
}
