package codingTest;
import java.util.Scanner;

public class main002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = Long.parseLong(sc.nextLine());
        String str = sc.nextLine();
        String scores[] = str.split(" ");
        long sum = 0;
        long max = Long.parseLong(scores[0]);

        for (int i = 0; i < n; i++) {
            long score = Long.parseLong(scores[i]);
            if (max < score)
                max = score;
            sum += score;
        }
        System.out.println(sum * 100.0 / max / n);
        sc.close();
    }
}
