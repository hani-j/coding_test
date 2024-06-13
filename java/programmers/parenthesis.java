package programmers;

import java.util.Stack;

public class parenthesis {
	static public int solution(String s) {
        int answer = 0;
        int len = s.length();
        s += s;
        for (int i = 0; i < len; i++) {
            Stack<Character> stack = new Stack<>();
            for (int j = i; j < i + len; j++) {
                char c = s.charAt(j);
                if (!stack.isEmpty()) {
                    char p = stack.peek();
                    switch (c) {
                        case ']':
                            if (p == '[')
                                stack.pop();
                            else
                                stack.push(c);
                            break;
                        case '}':
                            if (p == '{')
                                stack.pop();
                            else
                                stack.push(c);
                            break;
                        case ')':
                            if (p == '(')
                                stack.pop();
                            else
                                stack.push(c);
                            break;
                        default:
                            stack.push(c);
                            break;
                    }
                } else
                    stack.push(c);
            }
            if (stack.isEmpty())
                answer++;
        }
        
        return answer;
    }

	public static void main(String[] args) {
		String s = "[](){}";
		String s2 = "}]()[{";
		
		System.out.println(solution(s));
		System.out.println(solution(s2));
	}
}
