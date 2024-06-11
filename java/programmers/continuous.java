package programmers;

import java.util.HashSet;
import java.util.Set;

public class continuous {
	static public int solution(int[] elements) {
        int len = elements.length;
        Set<Integer> set = new HashSet<>();
        
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < len; j++) {
                int plus = 0;
                for (int k = j; k < j + i; k++) {
                    plus += elements[k % len];
                }
                set.add(plus);
            }
            
        }
        return set.size();
    }

	public static void main(String[] args) {
		int[] elements = {7, 9, 1, 1, 4};
		System.out.println(solution(elements));
	}
}
