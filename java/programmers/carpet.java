package programmers;

public class carpet {
	static public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for (int i = 1; i <= yellow / i; i++) {
            int x = yellow / i;
            if ((x + 2) * 2 + i * 2 == brown) {
                answer[0] = x + 2;
                answer[1] = i + 2;
            }
        }
        return answer;
    }

	public static void main(String[] args) {
		int brown = 10;
		int yellow = 2;
		int[] answer = solution(brown, yellow);
		System.out.println(answer[0] + ", " + answer[1]);
	}
}
