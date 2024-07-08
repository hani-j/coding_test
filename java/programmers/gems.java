package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class gems {
	static public int[] solution(String[] gems) {
        Set<String> tmp = new HashSet<>();
        for (String str : gems) {
            tmp.add(str);
        }
        int size = tmp.size();
        List<Node> list = new ArrayList<>();
        
        for (int i = 0; i < gems.length; i++) {
            Set<String> set = new HashSet<>();
            for (int j = i; j < gems.length; j++) {
                set.add(gems[j]);
                if (set.size() == size) {
                    list.add(new Node(i + 1, j + 1));                       
                }
            }
        }
        
        int min = gems.length;
        Node node = new Node(0, 0);
        for (Node n : list) {
            if (min > n.e - n.s) {
                node = n;
                min = n.e - n.s;
            }
        }
        
        return new int[] {node.s, node.e};
    }
    
    static class Node {
        int s;
        int e;
        
        public Node(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

	public static void main(String[] args) {
		String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		int[] result = solution(gems);
		System.out.println(Arrays.toString(result));
	}
}
