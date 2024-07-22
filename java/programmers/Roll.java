package programmers;

import java.util.HashMap;
import java.util.Map;

public class Roll {
	static public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> Lmap = new HashMap<>();
        Map<Integer, Integer> Rmap = new HashMap<>();
        
        for (int i = 0; i < topping.length; i++) {
            Rmap.put(topping[i], Rmap.getOrDefault(topping[i], 0) + 1);
        }
        for (int i = 0; i < topping.length; i++) {
            int key = topping[i];
            if (Rmap.containsKey(key)) {
                int value = Rmap.get(key);
                if (value == 1)
                    Rmap.remove(key);
                else
                    Rmap.put(key, value - 1);
            }
            Lmap.put(key, Lmap.getOrDefault(topping[i], 0) + 1);
            
            if (Lmap.size() == Rmap.size())
                answer++;
        }
        return answer;
    }

	public static void main(String[] args) {
		int[] topping1 = {1, 2, 1, 3, 1, 4, 1, 2};
		System.out.println(solution(topping1));
		
		int[] topping2 = {1, 2, 3, 1, 4};
		System.out.println(solution(topping2));
	}
}
