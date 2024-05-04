package programmers;

public class joystick {
	static public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int min = len - 1;

        for (int i = 0; i < len; i++) {
            char c = name.charAt(i);
            int up = c - 'A';
            int down = 'Z' - c + 1;
            answer += Math.min(up, down);

            int next = i + 1;
            while (next < len && name.charAt(next) == 'A') {
                next++;
            }

            min = Math.min(min, i + len - next + Math.min(i, len - next));
        }

        answer += min;
        return answer;
    }

	public static void main(String[] args) {
		String name = "JEROEN";
		System.out.println(solution(name));
	}
}
