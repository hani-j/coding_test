package programmers;

import java.util.HashMap;
import java.util.Map;

public class clothes {

    static public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            if (map.containsKey(clothes[i][1])) {
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
            } else        
                map.put(clothes[i][1], 1);
        }
        int answer = 1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            answer *= (entry.getValue() + 1);
        }
        return answer - 1;
    }

	public static void main(String[] args) {
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		System.out.println(solution(clothes));
	}
}
