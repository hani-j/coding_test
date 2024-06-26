package programmers;

import java.util.Arrays;

public class phoneBook {

    static public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            String c = phone_book[i];
            String n = phone_book[i + 1];

            if (n.startsWith(c)) {
                return false;
            }
        }
        return true;
    }

	public static void main(String[] args) {
		String[] phone_book = {"119", "97674223", "1195524421"};
		System.out.println(solution(phone_book));
	}
}
