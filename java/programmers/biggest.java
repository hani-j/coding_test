package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class biggest {
	static public String solution(int[] numbers) {
        String answer = "";
        String[] numbs = new String[numbers.length];
        int zero = 0;
        for (int i = 0; i < numbers.length; i++) {
            numbs[i] = String.valueOf(numbers[i]);
            if (numbers[i] == 0)
                zero++;
        }
        if (zero == numbers.length)
            return "0";
        
        Arrays.sort(numbs, new Comparator<String>() {
            @Override
            public int compare(String s, String e) {
                return (e + s).compareTo(s + e);
            }
        });
        
        for (int i  = 0; i < numbs.length; i++) {
            answer += numbs[i];
        }
        return answer;
    }

	public static void main(String[] args) {
		int[] numbers = {3, 30, 34, 5, 9};
		int[] numbers2 = {0, 0, 0};
        
		System.out.println(solution(numbers));
        System.out.println(solution(numbers2));
	}
}
