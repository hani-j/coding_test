package programmers;

public class vowel {
	static public int solution(String word) {
        int answer = 0;
        int[] w = {781, 156, 31, 6, 1};
        char[] alpa = {'A', 'E', 'I', 'O', 'U'};
        
        for (int i = 0; i < word.length(); i++) {
            int idx = 0;
            for (int j = 0; j < alpa.length; j++) {
                if (word.charAt(i) == alpa[j]) {
                    idx = j;
                    break;
                }
            }
            answer += idx * w[i] + 1;
        }
        
        return answer;
    }

	public static void main(String[] args) {
		String word = "AAAAE";
		System.out.println(solution(word));
	}
}
