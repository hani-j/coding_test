package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 15-5 4134
public class primeNumber {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long N = Long.parseLong(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i ++) {
            Long n = Long.parseLong(br.readLine());
            Long prime = getPrime(n);
            sb.append(prime + "\n");
        }
        System.out.println(sb.toString());
    }

    static public Long getPrime(Long n) {
        while (true) {
            if (isPrime(n))
                break;
            else
                n++;
        }
        return n;
    }

    static public boolean isPrime(long number) {
        if (number < 2)
            return false;
        if (number != 2 && number % 2 == 0)
            return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }
}
