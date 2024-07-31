package backjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Continuous {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] d = new int[n];
		d[0] = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			d[i] = Math.max(num, d[i - 1] + num);
		}
		
		System.out.println(Arrays.stream(d).max().orElseThrow());
	}
}
