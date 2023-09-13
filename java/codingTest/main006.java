package codingTest;

import java.util.Scanner;

public class main006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;

        for (int i = 1; i <= N; i++) {
            long sum = 0;
            for (int j = i; j<= N; j++) {
                sum += j;
                if (sum == N)
                    count++;
                else if (sum > N)
                    break;
            }
        }
        System.out.println(count);
        sc.close();
    }
}
