package programmers;

public class baseNum {
	static public String solution(int n, int t, int m, int p) {
        String answer = "";
        
        int num = 0;
        int check = 1;
		// Integer.toString(num, n);
        while (answer.length() < t) {
            String str = getTrans(n, num);
            for (int i = 0; i < str.length(); i++) {
                if (check == p)
                    answer += str.charAt(i);
                check++;
                if (check > m)
                    check = 1;
                if (answer.length() == t)
                    break;
            }
            num++;
        }
        return answer;
    }

    static public String getTrans(int n, int target) {
        if (target == 0) return "0";
        StringBuilder sb = new StringBuilder();
        
        while (target > 0) {
			int num = target % n;
			switch (num) {
				case 10:
					if (n > 10)
						sb.append("A");
					break;
				case 11:
					sb.append("B");					
					break;
				case 12:
					sb.append("C");					
					break;
				case 13:
					sb.append("D");					
					break;
				case 14:
					sb.append("E");					
					break;
				case 15:
					sb.append("F");					
					break;
				default:
					sb.append(num);
					break;
			}
            target /= n;
        }
        return sb.reverse().toString();
    }

	public static void main(String[] args) {
		int n1 = 2;
		int t1 = 4;
		int m1 = 2;
		int p1 = 1;
		System.out.println(solution(n1, t1, m1, p1));

		int n2 = 16;
		int t2 = 16;
		int m2 = 2;
		int p2 = 1;
		System.out.println(solution(n2, t2, m2, p2));
	}
}
