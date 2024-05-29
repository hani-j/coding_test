package programmers;

import java.util.Arrays;
import java.util.Collections;

public class min {
	static public int solution(int []A, int []B) {
        int answer = 0;
        Arrays.sort(A);
        Integer[] b = new Integer[A.length];
        for (int i = 0; i < B.length; i++) {
            b[i] = Integer.valueOf(B[i]);
        }
        
        Arrays.sort(b, Collections.reverseOrder());
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * b[i];
        }
        return answer;
    }

	public static void main(String[] args) {
		int[] A = {1, 4, 2};
		int[] B = {5, 4, 4};
		System.out.println(solution(A, B));
	}
}
