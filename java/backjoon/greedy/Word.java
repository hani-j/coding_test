package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Word {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] str = new String[N];
		for (int i = 0; i < N; i++) {
			str[i] = br.readLine();
		}

		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			int len = str[i].length();
			for (int j = 0; j < len; j++) {
				char c = str[i].charAt(j);
				if (map.containsKey(c)) {
					map.put(c, map.get(c) + (int)Math.pow(10, len - j - 1));
				} else
					map.put(c, (int)Math.pow(10, len - j - 1));
			}
		}

		List<Map.Entry<Character, Integer>> l = new ArrayList<>(map.entrySet());
		l.sort((v1, v2) -> v2.getValue().compareTo(v1.getValue()));
		int sum = 0;
		int n = 9;
		for (Map.Entry<Character, Integer> v : l) {
			sum += v.getValue() * n;
			n--;
		}
		System.out.println(sum);
	}
}
