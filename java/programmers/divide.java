package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class divide {
	static public int solution(int n, int[][] wires) {
        int answer = 100;
        int idx = 0;
        for (int i = 0; i < wires.length; i++) {
            List<Integer>[] list = new List[n + 1];
            int[] visited = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                list[j] = new ArrayList<>();
            }
            for (int j = 0; j < wires.length; j++) {
                if (idx != j) {
                    list[wires[j][0]].add(wires[j][1]);
                    list[wires[j][1]].add(wires[j][0]);
                }
            }
            
            int count = 0;
            int left = 0;
            int right = 0;
            for (int j = 1; j <= n; j++) {
                if (visited[j] == 0) {
                    int r = check(list, visited, j);
                    count++;
                    if (left == 0)
                        left = r;
                    else
                        right = r;
                }
            }
            if (count == 2)
                answer = Math.min(answer, Math.abs(left - right));
            idx++;
        }
        return answer;
    }
    
    static public int check(List<Integer>[] list, int[] visited, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = 1;
        int count = 1;
        
        while (!q.isEmpty()) {
            int c = q.poll();
            for (int n : list[c]) {
                if (visited[n] == 0) {
                    visited[n] = 1;
                    q.add(n);
                    count++;
                }
            }
        }
        return count;
    }

	public static void main(String[] args) {
		int n = 9;
		int[][] wires = {{1,3}, {2,3}, {3,4}, {4,5}, {4,6}, {4,7}, {7,8}, {7,9}};
		System.out.println(solution(n, wires));
	}
}
