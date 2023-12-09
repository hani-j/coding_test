package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 16-4 4949
public class balance {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();
            if (str.equals("."))
                break;
            StringTokenizer st = new StringTokenizer(str);
            Stack<Character> stack = new Stack<>();
            while (st.hasMoreTokens()) {
                String token = st.nextToken();
                for (int i = 0; i < token.length(); i++) {
                    char c = token.charAt(i);
                    if (c == '(')
                        stack.push(c);
                    else if (c == '[')
                        stack.push(c);
                    else if (c == ')') {
                        if (!stack.isEmpty() && stack.peek().equals('('))
                            stack.pop();
                        else
                            stack.push(c);
                    } else if (c == ']') {
                        if (!stack.isEmpty() && stack.peek().equals('['))
                            stack.pop();
                        else
                            stack.push(c);
                    }
                }
            }
            if (stack.isEmpty())
                sb.append("yes\n");
            else
                sb.append("no\n");
        }
        System.out.println(sb.toString());
    }
}
