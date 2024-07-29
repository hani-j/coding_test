package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Thirty {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strN = br.readLine();
		List<Integer> list = new ArrayList<>();
		boolean zero = false;
		int sum = 0;
		for (int i = 0; i < strN.length(); i++) {
			sum += strN.charAt(i) - '0';
			list.add(strN.charAt(i) - '0');
			if (zero == false && strN.charAt(i) == '0') {
				zero = true;
			}
		}
		if (zero == false || sum % 3 != 0) {
			System.out.println("-1");
			return ;
		}
			
		list.sort(Comparator.reverseOrder());
		StringBuilder sb = new StringBuilder();
		for (Integer n : list) {
			sb.append(n);
		}
		System.out.println(sb.toString());
	}
}
