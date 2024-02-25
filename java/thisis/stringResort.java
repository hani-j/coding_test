package thisis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// implementation 08
public class stringResort {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split("");

		int sum = 0;
		List<String> str = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].charAt(0) >= 'A' && arr[i].charAt(0) <= 'Z')
				str.add(arr[i]);
			else
				sum += Integer.parseInt(arr[i]);
		}

		str.sort(null);
		StringBuilder sb = new StringBuilder();
		for (String s : str)
			sb.append(s);
		System.out.println(sb.toString() + sum);
	}
}
