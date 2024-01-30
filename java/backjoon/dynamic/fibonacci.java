package backjoon.dynamic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// dynamic 1003
public class fibonacci {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] d = new int[41];

		d[0] = 0;
		d[1] = 1;
		for (int i = 2; i < 41; i++) {
			d[i] = d[i - 1] + d[i - 2];
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			int zero = n - 1 >= 0 ? n - 1 : 1;
			bw.write(d[zero] + " " + d[n] + "\n");
		}
		bw.flush();
		bw.close();
	}
}
