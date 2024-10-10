package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sensor {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int[] sensor = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
		sensor[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(sensor);

		int[] diff = new int[N];
		for (int i = 1; i < N; i++) {
			diff[i] = sensor[i] - sensor[i - 1];
		}

		int max = 0;
		for (int i = 1; i < K; i++) {
			for (int j = 1; j < N; j++) {
				if (diff[max] < diff[j])
					max = j;
			}
			diff[max] = 0;
			max = 0;
		}
		int sum = 0;
		int len = 0;
		for (int i = 1; i < N; i++) {
			while (i < N && diff[i] != 0)
				len += diff[i++];
			sum += len;
			len = 0;
		}
		System.out.println(sum);
	}
}
