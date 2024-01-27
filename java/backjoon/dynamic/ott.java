package backjoon.dynamic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// dynamic 9095
public class ott {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int T = Integer.parseInt(br.readLine());
		int[] d = new int[12];

		d[0] = 1;
		for (int i = 1; i < 12; i++) {
			if (i - 1 >= 0) {
				d[i] += d[i - 1];
			}
			if (i - 2 >= 0) {
				d[i] += d[i - 2];
			}
			if (i - 3 >= 0) {
				d[i] += d[i - 3];
			}
		}

		// d[1] = 1;
        // d[2] = 2;
        // d[3] = 4;

        // for (int i = 4; i <= 11; i++) {
        //     d[i] = d[i-1] + d[i-2] + d[i-3];
        // }

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			bw.write(d[n] + "\n");
		}
		bw.flush();
		bw.close();
	}
}
