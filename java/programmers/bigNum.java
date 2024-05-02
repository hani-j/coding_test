package programmers;

public class bigNum {
	static public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int idx = 0;
        int len = number.length() - k;

        for (int j = 0; j < len; j++) {
            char max = '0';

            for (int i = idx; i <= number.length() - len + j; i++) {
                if (number.charAt(i) > max) {
                    max = number.charAt(i);
                    idx = i + 1;
                }
                if (max == '9')
                    break;
            }
            answer.append(max);
        }
        return answer.toString();
    }

	public static void main(String[] args) {
		String number = "1924";
		int k = 2;
		System.out.println(solution(number, k));
	}
}
