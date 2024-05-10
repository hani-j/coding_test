package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class words {
	static List<Node>[] list;
    static int INF = 100;
    static int len;
    static int tNum;
    static int min = INF;

    static public int solution(String begin, String target, String[] words) {
        int answer = 0;
        if (!Arrays.asList(words).contains(target))
            return 0;
        len = words.length;
        list = new List[len];
        List<Node> start = new ArrayList<>();
        
        for (int i = 0; i < len; i++) {
            list[i] = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                if (check(words[i], words[j])) {
                    list[i].add(new Node(words[j], j));
                }
            }
            if (target.equals(words[i]))
                tNum = i;
            if (check(begin, words[i])) {
                start.add(new Node(words[i], i));
            }
        }
        for (Node n : start) {
            dfs(n.str, n.i);
        }
        if (min == INF)
            return 0;
        return min;
    }
    
    static class Node {
        String str;
        int i;
        
        public Node(String str, int i) {
            this.str = str;
            this.i = i;
        }
    }
    
    static public boolean check(String str1, String str2) {
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(i))
                count++;
        }
        if (count == str1.length() - 1)
                return true;
        return false;
    }
    
    static public void dfs(String str, int start) {
        int[] visited = new int[len];
        Arrays.fill(visited, INF);
        visited[start] = 1;
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(str, start));
        
        while(!stack.isEmpty()) {
            Node c = stack.pop();
            if (c.i == tNum) {
                min = Math.min(min, visited[c.i]);
            }
            for (Node n : list[c.i]) {
                if (visited[n.i] == INF) {
                    visited[n.i] = visited[c.i] + 1;
                    stack.push(n);
                    if (n.i == tNum) {
                        min = Math.min(min, visited[n.i]);
                    }
                }
            }
        }
    }

	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		System.out.println(solution(begin, target, words));
	}
}
