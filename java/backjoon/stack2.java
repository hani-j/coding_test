package backjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

// 16-1 28278
public class stack2 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = sc.nextInt();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (num == 1) {
                int n = sc.nextInt();
                stack.push(n);
            }
            if (num == 2) {
                if (stack.size() > 0)
                    bw.write(stack.pop() + "\n");
                else
                    bw.write("-1\n");
            }
            if (num == 3)
                bw.write(stack.size() + "\n");
            if (num == 4){
                if (stack.size() == 0)
                    bw.write("1\n");
                else
                    bw.write("0\n");
            }
            if (num == 5) {
                if (stack.size() > 0)
                    bw.write(stack.peek() + "\n");
                else
                    bw.write("-1\n");
            }
        }
        bw.flush();
        sc.close();
    }
}
