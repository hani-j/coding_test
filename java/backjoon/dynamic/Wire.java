package backjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Wire {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.add(new int[]{a, b});
		}
		list.sort(Comparator.comparingInt(a -> a[0]));

		int[] d = new int[N];
		for (int i = 0; i < N; i++) {
			d[i] = 1;
            for (int j = 0; j < i; j++) {
                if (list.get(i)[1] > list.get(j)[1]) {
                    d[i] = Math.max(d[i], d[j] + 1);
                }
            }
        }
		int max = Arrays.stream(d).max().getAsInt();
		System.out.println(N - max);
	}
}
