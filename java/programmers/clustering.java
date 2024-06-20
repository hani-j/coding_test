package programmers;

import java.util.ArrayList;
import java.util.List;

public class clustering {
	static public int solution(String str1, String str2) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        String tmp = "";
        for (int i = 0; i < str1.length(); i++) {
            if (Character.isLetter(str1.charAt(i)))
                tmp += Character.toUpperCase(str1.charAt(i));
			else
				tmp = "";
            if (tmp.length() == 2) {
                list1.add(tmp);
				tmp = Character.toUpperCase(str1.charAt(i)) + "";
            }
        }
		tmp = "";
        for (int i = 0; i < str2.length(); i++) {
            if (Character.isLetter(str2.charAt(i)))
				tmp += Character.toUpperCase(str2.charAt(i));
			else
				tmp = "";
            if (tmp.length() == 2) {
                list2.add(tmp);
				tmp = Character.toUpperCase(str2.charAt(i)) + "";
            }
        }
        int min = 0;
        for (String s : list1) {
            if (list2.contains(s)) {
                min++;
				list2.remove(s);
			}
        }
        int max = list1.size() + list2.size();
		if (max == 0) return 65536;
        return min * 65536 / max;
    }
	
	public static void main(String[] args) {
		String str1 = "FRANCE";
		String str2 = "french";
		System.out.println(solution(str1, str2));

		String str21 = "E=M*C^2";
		String str22 = "e=m*c^2";
		System.out.println(solution(str21, str22));
	}
}
