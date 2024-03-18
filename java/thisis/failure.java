package thisis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class failure {
	public static void main(String[] args) {
		int N = 5;
		int[] stages = {2,1,2,6,2,4,3,3};
		int[] result = solution(N, stages);
		for (int r : result)
		System.out.println(result);
	}

	public static int[] solution(int N, int[] stages) {
		List<Node> answer = new ArrayList<>();
		int len = stages.length;
		for (int i = 1; i <= N + 1; i++) {
			int count = 0;
			for (int s : stages) {
				if (i == s)
					count++;
			}

			float fail = 0;
			if (len == 0)
				fail = 0;
			else
				fail = count / len;
			answer.add(new Node(i, fail));
			
		}
        return answer;
    }

	static class Node implements Comparable<Node>{
		int i;
		float f;

		public Node(int i, float f) {
			this.i = i;
			this.f = f;
		}

		@Override
		public int compareTo(Node n) {
			if (n.f == this.f)
				return this.i - n.i;
			return this.f - n.f;
		}
	}
}
