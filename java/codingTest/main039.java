package codingTest;

import java.util.Scanner;

public class main039 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] array = new int[10000001];
        for (int i = 2; i <= 10000000; i++) {
            array[i] = i;
        }
        for (int i = 2; i <= Math.sqrt(10000000); i++) {
            if (array[i] > 0) {
                for (int j = i*2; j <= 10000000; j+=i) {
                    array[j] = 0;
                }
            }
        }
        int i = N;
        while (true) {
            if (array[i] != 0) {
                int result = array[i];
                if (isPalindrome(result)) {
                    System.out.println(result);
                    break;
                }
            }
            i++;
        }
        sc.close();
    }

    public static boolean isPalindrome(int target) {
        char tmp[] = String.valueOf(target).toCharArray();
        int s = 0;
        int e = tmp.length - 1;
        while (s < e) {
            if (tmp[s] != tmp[e])
                return false;
            s++;
            e--;
        }
        return true;
    }
}
