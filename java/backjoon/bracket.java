package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class bracket {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] list = st.nextToken().split("");
            Stack<String> stack = new Stack<>();
            boolean VPS = true;
            for (int j = 0; j < list.length; j++) {
                String bracket = list[j];
                if (bracket.equals("("))
                    stack.push("(");
                else {
                    if (stack.isEmpty()) {
                        VPS = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if (stack.isEmpty() && VPS == true)
                bw.write("YES\n");
            else if (VPS == false || !stack.isEmpty())
                bw.write("NO\n");
        }
        bw.flush();
    }
}
