package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 15-5 4134
public class primeNumber {
    static int range = 2000000000;
    static int[] prime = new int[range + 1];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long N = Long.parseLong(br.readLine());

        setPrimeNumber();
        for (long i = 0; i < N; i++) {
            long n  = Long.parseLong(br.readLine());
            if (n < 2000000001)
                System.out.println(getPrimeNumber((int)n));
            else
                System.out.println(getBigPrimeNumber(n));
        }
    }

    static public void setPrimeNumber() {
        for (int i = 2; i < prime.length; i++) {
            prime[i] = i;
        }

        for (int i = 2; i < Math.sqrt(prime.length); i++) {
            if (prime[i] > 0) {
                for (int j = i * 2; j < 2000000001; j += i) {
                    prime[j] = 0;
                }
            }
        }
    }

    static public int getPrimeNumber(int number) {
        for (int i = number; i < prime.length; i++) {
            if (prime[i] > 0)
                return i;
        }
        return 0;
    }

    static public long getBigPrimeNumber(long number) {
        while (true) {
            if (isPrime(number))
                return number;
            else
                number++;
        }
    }

    static public boolean isPrime(long number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }
}
