package programmers;

import java.util.Stack;

public class parcel {
	static public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> assi = new Stack<>();
        
        int n = 1;
        for (int i = 0; i < order.length; i++) {
            while (order[i] > n) {
                assi.push(n);
                n++;
            }
            if (order[i] == n) {
                answer++;
                n++;
            } else {
                if (assi.peek() == order[i]) {
                    assi.pop();
                    answer++;
                } else
                    break;
            }
        }
        return answer;
    }

	public static void main(String[] args) {
		int[] order = {4, 3, 1, 2, 5};
		System.out.println(solution(order));

		int[] order2 = {5, 4, 3, 2, 1};
		System.out.println(solution(order2));
	}
}
