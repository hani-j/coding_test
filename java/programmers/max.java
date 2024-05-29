package programmers;

public class max {
	static public String solution(String s) {
        String answer = "";
        String[] list = s.split(" ");
        int min = 1000000;
        int max = -1000000;
        for (int i = 0; i < list.length; i++) {
            int c = Integer.parseInt(list[i]);
            if (min > c)
                min = c;
            if (max < c)
                max = c;
        }
        answer = min + " " + max;
        return answer;
    }

	public static void main(String[] args) {
		String s = "1 2 3 4";
		System.out.println(solution(s));
	}
}
