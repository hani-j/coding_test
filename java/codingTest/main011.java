package codingTest;
import java.util.Scanner;
import java.util.Stack;

public class main011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        Stack<Integer> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        int[] arr = new int[N];
        boolean result = true;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int num = 1;
        for (int i = 0; i < N; i++) {
            int n = arr[i];
            if (num <= n) {
                while (num <= n) {
                    stack.push(num++);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            }
            else {
                if (!stack.isEmpty() && stack.peek() == n) {
                    stack.pop();
                    sb.append("-\n");
                }
                else {
                    System.out.println("NO");
                    result = false;
                    break;
                }
            }
        }
        if (result)
            System.out.println(sb.toString());
    }
}
