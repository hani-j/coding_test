package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class privacies {
	static public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> l = new ArrayList<>();
        
        String[] todays = today.split("\\.");
        int[] iTodays = new int[todays.length];
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String[] ts = terms[i].split(" ");
            map.put(ts[0], Integer.parseInt(ts[1]));
        }
        for (int i = 0; i < todays.length; i++)
            iTodays[i] = Integer.parseInt(todays[i]);
        for (int i = 0; i < privacies.length; i++) {
            String[] ps = privacies[i].split(" ");
			String s = ps[0];
            String[] days = s.split("\\.");
            int m = map.get(ps[1]) + Integer.parseInt(days[1]);
            int y = m / 12;
            m = m % 12;
            if (m == 0) {
                y -= 1;
                m = 12;
            }
            y += Integer.parseInt(days[0]);
            if (iTodays[0] > y || (iTodays[0] == y && iTodays[1] > m) || (iTodays[0] == y && iTodays[1] == m && iTodays[2] >= Integer.parseInt(days[2]))) {
                l.add(i + 1);
            }
        }
        int[] result = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            result[i] = l.get(i);
        }
        
        return result;
    }

	public static void main(String[] args) {
		String today = "2022.05.19";
		String[] terms = {"A 6", "B 12", "C 3"};
		String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
	
		int[] result = solution(today, terms, privacies);
		System.out.println(Arrays.toString(result));
	}
}
