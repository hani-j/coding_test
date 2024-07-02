package programmers;

import java.util.Arrays;

public class set {
	static public int[] solution(int n, int s) {
        if (s == 1 || s < n)
            return new int[]{-1};
			
        int[] answer = new int[n];
        Arrays.fill(answer, s / n);

        int rest = s % n;
        while (rest > 0) {
            answer[--n]++;
            rest--;
        }
        return answer;
    }

	public static void main(String[] args) {
		int n1 = 2;
		int s1 = 9;
		int[] result1 = solution(n1, s1);
		System.out.println(Arrays.toString(result1));

		int n2 = 2;
		int s2 = 1;
		int[] result2 = solution(n2, s2);
		System.out.println(Arrays.toString(result2));
	}
}
