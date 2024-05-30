package programmers;

public class jaden {
	static public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ')
                first = true;
            else if (first == true && c >= 'a' && c <= 'z') {
                c = (char) (c - 32);
                first = false;
            }
            else if (first == false && c >= 'A' && c <= 'Z')
                c = (char) (c + 32);
            else
                first = false;
                
            sb.append(c);
        }
        return sb.toString();
    }

	public static void main(String[] args) {
		String s = "3people unFollowed me";
		System.out.println(solution(s));
	}
}
