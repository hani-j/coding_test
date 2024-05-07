package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class network {
	static int[] visited;
    static List<Integer>[] list;
    static int answer = 0;
    static public int solution(int n, int[][] computers) {
        list = new List[n];
        visited = new int[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<Integer>();
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1)
                    list[i].add(j);
            }
        }
        
        for (int i = 0; i < n; i++) {
            search(i);
        }
        return answer;
    }
    
    static public void search(int i) {
        Queue<Integer> queue = new LinkedList<>();
        if (visited[i] == 1) {
            return;
        }
        answer++;
        visited[i] = 1;
        queue.add(i);
        
        while (!queue.isEmpty()) {
            int n = queue.poll();
            for (int l : list[n]) {
                if (visited[l] == 0) {
                    visited[l] = 1;
                    queue.add(l);
                }
            }
        }
    }

	public static void main(String[] args) {
		int n = 3;
		int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		System.out.println(solution(n, computers));
	}
}