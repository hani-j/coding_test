package codingTest;

import java.util.Scanner;

public class main001 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        char[] cstr = str.toCharArray();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += cstr[i] - '0';
        }
        System.out.println(sum);
        sc.close();
    }
}
