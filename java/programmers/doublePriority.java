package programmers;

import java.util.PriorityQueue;
import java.util.Queue;

public class doublePriority {
	static public int[] solution(String[] operations) {
        int[] answer = new int[2];
        Queue<Integer> q = new PriorityQueue<>();
        
        for (int i = 0; i < operations.length; i++) {
            String[] oper = operations[i].split(" ");
            if (oper[0].equals("I")) {
                q.add(Integer.parseInt(oper[1]));
            } else {
                if (oper[1].equals("-1")) {
                    if (!q.isEmpty())
                        q.poll();
                } else {
                    if (!q.isEmpty()) {
                        Queue<Integer> tmp = new PriorityQueue<>();
                        while (q.size() > 1) {
                            tmp.add(q.poll());
                        }
                        q = tmp;
                    }
                }
            }
        }
        if (q.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[1] = q.poll();
            while (q.size() > 1) {
                q.poll();
            }
            answer[0] = q.poll();
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        int[] answer = solution(operations);
        System.out.println(answer[0] + ", " + answer[1]);
    }
}
