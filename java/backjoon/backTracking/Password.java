package backjoon.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Password {
	static String[] chars;
	static int L;
	static int C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		chars = new String[C];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++)
			chars[i] = st.nextToken();
		Arrays.sort(chars);

		List<List<String>> pass = getPass();
		StringBuilder sb = new StringBuilder();
		for (List<String> p : pass) {
			sb.append(String.join("", p));
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static List<List<String>> getPass() {
		List<List<String>> pass = new ArrayList<>();
		boolean[] visited = new boolean[C];
		make(pass, new ArrayList<>(), visited, 0);
		return pass;
	}

	public static void make(List<List<String>> p, List<String> l, boolean[] v, int s) {
		if (l.size() == L && check(l)) {
			p.add(new ArrayList<>(l));
			return;
		}
		for (int i = s; i < C; i++) {
			if (!v[i]) {
				l.add(chars[i]);
				v[i] = true;
				make(p, l, v, i + 1);
				l.remove(l.size() - 1);
				v[i] = false;
			}
		}
	}

	public static boolean check(List<String> l) {
		String[] vowel= {"a", "e", "i", "o", "u"};
		int count = 0;
		for (String s : l) {
			if (Arrays.stream(vowel).anyMatch(v -> v.equals(s)))
				count++;
		}
		if (count > 0 && l.size() - count > 1)
			return true;
		return false;
	}
}
