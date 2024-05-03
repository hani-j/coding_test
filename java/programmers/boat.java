package programmers;

import java.util.Arrays;

public class boat {
	static public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int s = 0;
        int e = people.length - 1;
        int l;
        
        while (s <= e) {
            if (s == e) {
                answer++;
                break;
            }
            l = people[s] + people[e];
            if (l <= limit) {
                s++;
                e--;
                answer++;
            } else {
                e--;
                answer++;
            }
        }
        
        return answer;
    }

	public static void main(String[] args) {
		int[] people = {70, 50, 80, 50};
		int limit = 100;

		System.out.println(solution(people, limit));
	}
}
