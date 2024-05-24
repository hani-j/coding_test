package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class path {
	static public String[] solution(String[][] tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        
        for (String[] t : tickets) {
            graph.putIfAbsent(t[0], new PriorityQueue<>());
            graph.get(t[0]).add(t[1]);
        }

        List<String> path = new ArrayList<>();
        dfs("ICN", graph, path);

        return path.toArray(new String[0]);
    }

    static public void dfs(String air, Map<String, PriorityQueue<String>> graph, List<String> path) {
        PriorityQueue<String> des = graph.get(air);
        
        while (des != null && !des.isEmpty()) {
            String nextAir = des.poll();
            dfs(nextAir, graph, path);
        }
        
        path.add(0, air);
    }

	public static void main(String[] args) {
		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		String[] result = solution(tickets);

		for (String str : result) {
			System.out.println(str);
		}
	}
}
