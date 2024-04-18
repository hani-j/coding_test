package programmers;

import java.util.Stack;

public class notSameNum {
	public static void main(String[] args) {
		int[] arr = {1, 1, 3, 3, 0, 1, 1};
		int[] answer = solution(arr);
		for (int num : answer)
			System.out.print(num + " ");
	}

	static public int[] solution(int []arr) {
        Stack<Integer> q = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (!q.isEmpty() && q.peek() == arr[i]) {
                continue;
            }
            q.push(arr[i]);
        }
        
        int[] answer = new int[q.size()];
        for (int i = q.size() - 1; i >= 0; i--) {
            answer[i] = q.pop();
        }
        return answer;
    }
}
