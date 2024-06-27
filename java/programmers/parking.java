package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class parking {
	static public int[] solution(int[] fees, String[] records) {
        Map<String, String> map = new HashMap<>();
        Map<String, Integer> ans = new HashMap<>();
        for (int i = 0; i < records.length; i++) {
            String[] list = records[i].split(" ");
            if (list[2].equals("IN")) {
                map.put(list[1], list[0]);
            } else {
                int time = getTime(map.get(list[1]), list[0]);
				System.out.println(time);
                if (ans.containsKey(list[1]))
                    ans.put(list[1], ans.get(list[1]) + time);
                else
                    ans.put(list[1], time);
                map.remove(list[1]);
            }
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
			String number = entry.getKey();
            int time = getTime(entry.getValue(), "23:59");
			System.out.println(time);
            
            if (ans.containsKey(number))
                ans.put(number, ans.get(number) + time);
            else
                ans.put(number, time);
        }
        
        
        List<Map.Entry<String, Integer>> e = new ArrayList<>(ans.entrySet());
        e.sort(Map.Entry.comparingByKey());
        
        int[] answer = new int[e.size()];
        for (int i = 0; i < e.size(); i++) {
			int time = e.get(i).getValue();
			System.out.println(time);
			int cost = fees[1];
            if (time > fees[0])
                cost += (int) Math.ceil((time - fees[0]) / (double) fees[2]) * fees[3];
            answer[i] = cost;
        }
        return answer;
    }
    
    static public int getTime(String t1, String t2) {
		System.out.println(t1 + " " + t2);
        String[] time = t1.split(":");
        int h1 = Integer.parseInt(time[0]);
        int m1 = Integer.parseInt(time[1]);

        String[] time2 = t2.split(":");
        int h2 = Integer.parseInt(time2[0]);
        int m2 = Integer.parseInt(time2[1]);
        
        int h = h2 - h1;
        int m = m2 - m1;
        if (m >= 60) {
            h++;
            m -= 60;
        } else if (m < 0) {
            h--;
            m += 60;
        }
        System.out.println(h + " " + m);
        return h * 60 + m;
    }

	public static void main(String[] args) {
		int[] fees = {180, 5000, 10, 600};
		String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		int[] result = solution(fees, records);
		System.out.println(Arrays.toString(result));
	}
}
