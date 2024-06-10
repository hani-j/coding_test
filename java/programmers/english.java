package programmers;

import java.util.HashSet;
import java.util.Set;

public class english {
	static public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        char end = words[0].charAt(words[0].length() - 1);
        set.add(words[0]);
        
        for (int i = 1; i < words.length; i++) {
            if (set.contains(words[i]) || end != words[i].charAt(0)) {
                answer[0] = (i % n) + 1;
                answer[1] = i / n + 1;
                return answer;
            }
            end = words[i].charAt(words[i].length() - 1);
            set.add(words[i]);
        }
        return answer;
    }

	public static void main(String[] args) {
		int n = 3;
		String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		
		int[] answer = solution(n, words);
		System.out.println("[" + answer[0] + "," + answer[1] + "]");
	}
}
