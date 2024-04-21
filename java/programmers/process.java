package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class process {
	static public int solution(int[] priorities, int location) {
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Node(i, priorities[i]));
        }
        Arrays.sort(priorities);
        int idx = priorities.length - 1;
        int answer = 0;
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            if (n.o == priorities[idx]) {
                answer++;
                idx--;
                if (n.a == location)
                    return answer;
            } else {
                queue.add(n);
            }
        }
        return answer;
    }
    
    static class Node {
        int a;
        int o;
        
        public Node(int a, int o) {
            this.a = a;
            this.o = o;
        }
    }

	public static void main(String[] args) {
		int[] priorities = {2, 1, 3, 2};
		int location = 2;
		System.out.println(solution(priorities, location));
	}
}
