package thisis;

import java.util.ArrayList;
import java.util.List;

public class failure {
	public static void main(String[] args) {
		// int N = 5;
		// int[] stages = {2,1,2,6,2,4,3,3};
		int N = 4;
		int[] stages = {4,4,4,4,4};
		int[] result = solution(N, stages);
		for (int r : result)
			System.out.println(r);
	}

	public static int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		List<Node> list = new ArrayList<>();
		int len = stages.length;
		for (int i = 1; i <= N; i++) {
			int count = 0;
			for (int s : stages) {
				if (i == s)
					count++;
			}

			float fail = 0;
			if (len == 0)
				fail = 0;
			else
				fail = (float) count / len;
			list.add(new Node(i, fail));
			len -= count;
		}
		list.sort(null);
		for (int i = 0; i < N; i++) {
			answer[i] = list.get(i).i;
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
			return Float.compare(n.f, this.f);
		}
	}
}
