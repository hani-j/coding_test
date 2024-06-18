package programmers;

import java.util.Map;
import java.util.TreeMap;

public class cache {
	static public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Map<String, Integer> map = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i];
            if (map.containsKey(city)) {
                answer++;
                map.put(city, i);
            } else if (map.size() < cacheSize) {
                map.put(city, i);
                answer += 5;
            } else if (cacheSize > 0){
                int min = i;
                String key = "";
                for (Map.Entry<String, Integer> e : map.entrySet()) {
                    if (min > e.getValue()) {
                        min = e.getValue();
                        key = e.getKey();
                    }
                }
                map.remove(key);
                map.put(city, i);
                answer += 5;
            } else
                answer += 5;
        }
        return answer;
    }

	public static void main(String[] args) {
		int cacheSize = 3;
		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

		System.out.println(solution(cacheSize, cities));

		int cacheSize2 = 0;
		String[] cities2 = {"Jeju", "Jeju"};
		System.out.println(solution(cacheSize2, cities2));
	}
}
