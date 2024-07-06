package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class banned {
	static public int solution(String[] user_id, String[] banned_id) {
        List<List<String>> list = new ArrayList<>();
        
        for (int i = 0; i < banned_id.length; i++) {
            List<String> l = new ArrayList<>();
            for (int j = 0; j < user_id.length; j++) {
                if (banCheck(user_id[j], banned_id[i]))
                    l.add(user_id[j]);
            }
			System.out.println(l.toString());
            list.add(l);
        }
        
        Set<Set<String>> result = new HashSet<>();
        back(list, new HashSet<>(), 0, result);
        
        return result.size();
    }
    
    static public boolean banCheck(String user, String banned) {
        if (user.length() != banned.length())
            return false;
        for (int i = 0; i < banned.length(); i++) {
            if (banned.charAt(i) != '*' && user.charAt(i) != banned.charAt(i))
                return false;
        }
        return true;
    }

    static public void back(List<List<String>> list, Set<String> c, int i, Set<Set<String>> result) {
        if (i == list.size()) {
			System.out.println(c.toString());
            result.add(new HashSet<>(c));
            return;
        }
        
        for (String user : list.get(i)) {
            if (!c.contains(user)) {
                c.add(user);
                back(list, c, i + 1, result);
                c.remove(user);
            }
        }
    }
    
	public static void main(String[] args) {
		String[] user_id1 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id1 = {"fr*d*", "abc1**"};
		System.out.println(solution(user_id1, banned_id1));

		String[] user_id2 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id2 = {"fr*d*", "*rodo", "******", "******"};
		System.out.println(solution(user_id2, banned_id2));
	}
}
