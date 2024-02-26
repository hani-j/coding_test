package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// implementation 09
public class stringCompression {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		int min = s.length();
		for (int i = 1; i <= s.length() / 2; i++) {
			String str = s.substring(0, i);
			int len = 0;
			int count = 1;
			for (int j = 0; j <= s.length(); j += i) {
				int end = j + i < s.length() ? j + i : s.length();
				if (str.equals(s.substring(j, end))) {
					count++;
				} else {
					if (count > 1) {
						len += String.valueOf(count).length() + str.length();
						System.out.println("count : " + count + " count len : " + String.valueOf(count).length() + " str len : " + str.length());
					} else {
						len += str.length();
					}
					count = 1;
					str = s.substring(j, end);
				}
				if (j + i > s.length())
					len += s.length() - j;
			}
			if (len < min) {
				min = len;
			}
		}
		System.out.println(min);
	}
}
