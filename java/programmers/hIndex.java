package programmers;

import java.util.Arrays;

class hIndex {
	static public int solution(int[] citations) {
		int answer = 0;
		Arrays.sort(citations);
		int n = citations.length;

		for (int i = 0; i < n; i++) {
			int minCitations = n - i;
			if (citations[i] >= minCitations) {
				answer = minCitations;
				break;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		int[] citations = {3, 0, 6, 1, 5};
		System.out.println(solution(citations));
	}
}