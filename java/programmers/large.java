package programmers;

import java.util.Arrays;
import java.util.Stack;

public class large {
	static public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numbers.length; i++) {
			while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i])
				answer[stack.pop()] = numbers[i];
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        return answer;
    }
	
	// public int[] solution(int[] numbers) {
    //     int[] answer = new int[numbers.length];
        
    //     Stack<Node> stack = new Stack<>();
    //     for (int i = 0; i < numbers.length; i++) {
    //         if (!stack.isEmpty() && stack.peek().n < numbers[i]) {
    //             while (!stack.isEmpty() && stack.peek().n < numbers[i]) {
    //                 Node node = stack.pop();
    //                 answer[node.i] = numbers[i];
    //             }
    //         }
    //         stack.push(new Node(numbers[i], i));
    //     }
    //     while (!stack.isEmpty()) {
    //         Node node = stack.pop();
    //         answer[node.i] = -1;
    //     }
    //     return answer;
    // }

    // class Node {
    //     int n;
    //     int i;
        
    //     public Node(int n, int i) {
    //         this.n = n;
    //         this.i = i;
    //     }
    // }

	public static void main(String[] args) {
		int[] numbers = {2, 3, 3, 5};
		int[] result = solution(numbers);
		System.out.println(Arrays.toString(result));
	}
}
