package programmers;

public class discount {
	static public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        for (int i = 0; i < 10 && i < discount.length; i++) {
            for (int j = 0; j < want.length; j++) {
                if (discount[i].equals(want[j]))
                    number[j]--;
            }
		}

        for (int i = 0; i < discount.length; i++) {
            boolean right = true;
            for (int j = 0; j < number.length; j++) {
                if (number[j] > 0)
                    right = false;
            }
            if (right)
                answer++;
            cal(discount[i], want, number, +1);
            if (discount.length > 10 && i + 10 < discount.length)
                cal(discount[i + 10], want, number, -1);
        }
        return answer;
    }
    
    static public int[] cal(String s, String[] want, int[] number, int n) {
        for (int idx = 0; idx < number.length; idx++) {
            if (s.equals(want[idx])) {
                number[idx] += n;
				break;
			}
        }

		return number;
    }

	public static void main(String[] args) {
		String[] want = {"banana", "apple", "rice", "pork", "pot"};
		int[] number = {3, 2, 2, 2, 1};
		String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

		System.out.println(solution(want, number, discount));
	}
}
