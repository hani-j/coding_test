package programmers;

import java.util.Stack;

public class bracket {
	static boolean solution(String s) {
        boolean answer = true;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.add("(");
            else {
                if (!stack.isEmpty() && stack.peek().equals("("))
                    stack.pop();
                else
                    answer = false;
            }
        }
        if (!stack.isEmpty())
            answer = false;
        return answer;
    }

	public static void main(String[] args) {
		String s = "(())()";
		System.out.println(solution(s));
	}
}
