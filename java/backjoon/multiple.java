package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 26-4 1629 **
public class multiple {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		long result = power(A, B, C);
		
		System.out.println(result);
	}

	static public long power(long base, long exponent, long modulus) {
		long result = 1;

        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % modulus;
            }
            base = (base * base) % modulus;
            exponent /= 2;
        }
        return result;
	}

	// private static long calculateResult(long A, long B, long C) {
    //     if (B == 1) {
    //         return A % C;
    //     }

    //     long val = calculateResult(A, B / 2, C);
    //     val = val * val % C;
    //     if (B % 2 == 0) {
    //         return val;
    //     } else {
    //         return val * A % C;
    //     }
    // }
}
