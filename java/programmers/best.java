package programmers;

import java.util.*;

class best {

	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		int[] answer = solution(genres, plays);
		for (int a : answer) {
			System.out.print(a + " ");
		}
	}

    static public int[] solution(String[] genres, int[] plays) {
        int len = genres.length / 2 == 0 ? genres.length : genres.length - 1;
        int[] answer = new int[len];
        Map<String, Integer> map = new TreeMap<>(Collections.reverseOrder());
        Map<String, List<Node>> list = new HashMap<>(); 
        
        for (int i = 0; i < genres.length; i++) {
            if (map.containsKey(genres[i])) {
                map.put(genres[i], map.get(genres[i]) + plays[i]);
                list.get(genres[i]).add(new Node(plays[i], i));
            }
            else {
                map.put(genres[i], plays[i]);
                List<Node> l = new ArrayList<Node>();
                l.add(new Node(plays[i], i));
                list.put(genres[i], l);
            }
        }
        
        int idx = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            List<Node> nodes = list.get(key);
            nodes.sort(null);
            for (Node n : nodes) {
                answer[idx] = n.idx;
                idx++;
                if (idx == len)
                    break;
            }
            if (idx == len)
                break;
        }
        return answer;
    }
    
    static class Node implements Comparable<Node> {
        int plays;
        int idx;
        
        public Node(int plays, int idx) {
            this.plays = plays;
            this.idx = idx;
        }
        
        @Override
        public int compareTo(Node n) {
            if (this.plays == n.plays)
                return Integer.compare(n.idx, this.idx);
            return Integer.compare(n.plays, this.plays);
        }
    }
}