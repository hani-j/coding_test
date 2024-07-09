package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class gemsAns {
	static public int[] solution(String[] gems) {
        Set<String> gemTypes = new HashSet<>(Arrays.asList(gems));
        int size = gemTypes.size();
        
        int[] answer = new int[2];
        Map<String, Integer> map = new HashMap<>();
        
        int s = 0;
        int min = 100001;

        for (int i = 0; i < gems.length; i++) {
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);

            while (map.size() == size) {
                if (i - s < min) {
                    min = i - s;
                    answer[0] = s + 1;
                    answer[1] = i + 1;
                }

                map.put(gems[s], map.get(gems[s]) - 1);
                if (map.get(gems[s]) == 0) {
                    map.remove(gems[s]);
                }
                s++;
            }
        }
    
        return answer;
    }

	public static void main(String[] args) {
		String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		int[] result = solution(gems);
		System.out.println(Arrays.toString(result));
	}
}
