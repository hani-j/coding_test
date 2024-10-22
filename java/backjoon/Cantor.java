package backjoon;

import java.io.IOException;
import java.util.Scanner;

public class Cantor {
	static char[] arr;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (sc.hasNextInt()) {
			int N = sc.nextInt();
			int len = (int) Math.pow(3, N);
			arr = new char[len];
			if (N == 0)
				arr[0] = '-';
			else
				print(0, len);

			for (char c : arr)
				sb.append(c);
			sb.append('\n');
		}
		System.out.println(sb);
		sc.close();
	}

	public static void print(int s, int e) {
		if (e - s == 3) {
			arr[s] = '-';
			arr[s + 1] = ' ';
			arr[s + 2] = '-';
			return ;
		}
		int len = (e - s) / 3;
		print(s, s + len);
		erase(s + len, s + len * 2);
		print(s + len * 2, e);
	}

	public static void erase(int s, int e) {
		while (s <= e)
			arr[s++] = ' ';
	}
}
