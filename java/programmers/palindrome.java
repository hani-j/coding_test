package programmers;

public class palindrome {
	static public int solution(String s) {
        int answer = 1;

        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i - 1) == s.charAt(i)) {
                int start = i - 1;
				int idx = i;
                int count = 0;
            
                while (start >= 0 && idx < s.length() && s.charAt(start) == s.charAt(idx)) {
                    count += 2;
                    start--;
                    idx++;    
                }
                answer = Math.max(answer, count);
            }
			if (i > 1 && s.charAt(i - 2) == s.charAt(i)) {
				int start = i - 2;
				int idx = i;
                int count = 1;
            
                while (start >= 0 && idx < s.length() && s.charAt(start) == s.charAt(idx)) {
                    count += 2;
                    start--;      
                    idx++;    
                }
                answer = Math.max(answer, count);
			}
        }

        return answer;
    }

	public static void main(String[] args) {
		String s1 = "abcdcba";
		System.out.println(solution(s1));

		String s2 = "abacde";
		System.out.println(solution(s2));

		String s3 = "abbhcde";
		System.out.println(solution(s3));
	}
}
