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
        Map<String, Integer> map = new HashMap<>();
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
        
        List<String> sortedGenres = new ArrayList<>(map.keySet());
        sortedGenres.sort((a, b) -> map.get(b).compareTo(map.get(a)));
        List<Integer> ans = new ArrayList<>();
        int idx = 0;
        for (String genre : sortedGenres) {
            List<Node> nodes = list.get(genre);
            nodes.sort(null);
            int count = 0;
            for (Node n : nodes) {
                ans.add(n.idx);
                count++;
                if (count >= 2)
                    break;
            }
        }
        int[] answer = new int[ans.size()];
        idx = 0;
        for (int i : ans) {
            answer[idx++] = i;
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
                return Integer.compare(this.idx, n.idx);
            return Integer.compare(n.plays, this.plays);
        }
    }
}