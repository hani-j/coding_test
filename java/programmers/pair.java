package programmers;

import java.util.Stack;

public class pair {

	static public int solution(String s) {
        Stack<Character> st = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (!st.isEmpty() && st.peek() == s.charAt(i))
                st.pop();
            else
                st.push(s.charAt(i));
        }
        if (st.size() == 0)
            return 1;
        return 0;
    }

	/* 시간 초과
	public int solution(String s) {
        StringBuilder sb = new StringBuilder(s);
        int target = 0;
        while (target < sb.length() - 1 && sb.length() >= 2) {
            if (sb.charAt(target) == sb.charAt(target + 1)) {
                sb.deleteCharAt(target + 1);
                sb.deleteCharAt(target);
                target = 0;                
            } else
                target++;
        }
        if (sb.length() == 0)
            return 1;
        return 0;
    }
	 */

	public static void main(String[] args) {
		String s = "baabaa";
		System.out.println(solution(s));
	}
}
