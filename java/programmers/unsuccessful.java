package programmers;

import java.util.HashMap;
import java.util.Map;

public class unsuccessful {
	static public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : participant) {
            if (map.containsKey(str))
                map.put(str, map.get(str) + 1);
            else
                map.put(str, 1);
        }
        for (String str : completion) {
            if (map.get(str) == 1)
                map.remove(str);
            else
                map.put(str, map.get(str) - 1);
        }
        String key = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            key = entry.getKey();
        }
        return key;
    }

	public static void main(String[] args) {
		String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion = {"josipa", "filipa", "marina", "nikola"};
		System.out.println(solution(participant, completion));
	}
}
