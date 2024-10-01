package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Palindrome {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split("");
		Arrays.sort(str);
		StringBuilder sb = new StringBuilder();
		Stack<String> st = new Stack<>();

		int s = 0;
		String mid = "";
		boolean has = false;
		while (s < str.length - 1) {
			if (str[s].equals(str[s + 1])) {
				sb.append(str[s]);
				st.push(str[s]);
				s += 2;
			} else if (!has && str.length % 2 != 0) {
				mid = str[s];
				has = true;
				s++;
			} else {
				System.out.println("I'm Sorry Hansoo");
				return ;
			}
		}
		if (str.length % 2 != 0 && !has)
			sb.append(str[s]);
		else
			sb.append(mid);
		while (!st.isEmpty())
			sb.append(st.pop());
		System.out.println(sb);
	}

}
