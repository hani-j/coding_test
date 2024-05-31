package programmers;

public class binary {

	static public int[] solution(String s) {
        int[] answer = new int[2];
        int num = 0;
        int count = 0;
        int zero = 0;
        
        while (num != 1) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1')
                    num++;
            }
            zero += s.length() - num;
            s = trans(num);
			// s = Integer.toBinaryString(num);
			System.out.println(s + " " + num);
            count++;
			if (num == 1)
				break;
            num = 0;
        }
        answer[0] = count;
        answer[1] = zero;
        return answer;
    }
    
    static public String trans(int num) {
        StringBuilder sb = new StringBuilder();
        
        while (num > 0) {
            if (num % 2 == 0)
                sb.append("0");
            else
                sb.append("1");
			num /= 2;
        }
        sb.reverse();
        return sb.toString();
    }

	public static void main(String[] args) {
		String s = "110010101001";
		int[] result = solution(s);

		for (int num : result)
			System.out.println(num);
	}
}
