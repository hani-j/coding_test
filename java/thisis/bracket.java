package thisis;

import java.util.LinkedList;
import java.util.Queue;

public class bracket {
	public static void main(String[] args) {
		// String str = "(()())()";
		// String str = ")(";
		String str = "()))((()";
		System.out.println(solution(str));
	}

	private static boolean isCorrect(String w) {
		Queue<Character> q = new LinkedList<>();
		for (int i = 0; i < w.length(); i++) {
			if (w.charAt(i) == '(')
				q.add('(');
			else {
				if (!q.isEmpty())
					q.poll();
				else
					return false;
			}
		}
		if (q.isEmpty())
			return true;
		return false;
	}
	
	private static String[] devide(String p) {
		String[] str = new String[2];
		int left = 0;
		int right = 0;
		
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '('){
				left++;
			}
			else {
				right++;
			}
			if (left == right) {
				str[0] = p.substring(0, i + 1);
				str[1] = p.substring(i + 1, p.length());
				return str;
			}
		}
		str[0] = p;
		str[1] = "";
		return str;
	}

	private static String solution(String p) {
		if (p.equals("") || isCorrect(p))
			return p;
		String[] str = devide(p);
		String answer = "";
		if (isCorrect(str[0])) {
			answer = str[0] + solution(str[1]);
		} else {
			answer += "(";
			answer += solution(str[1]);
			answer += ")";
			String u = "";
			str[0] = str[0].substring(1, str[0].length() - 1);
			for (int i = 0; i < str[0].length(); i++) {
				if (str[0].charAt(i) == '(')
					u += ')';
				else
					u += '(';
			}
			answer += u;
		}
		return answer;
	}
}
