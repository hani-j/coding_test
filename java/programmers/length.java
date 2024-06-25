package programmers;

import java.util.ArrayList;
import java.util.List;

public class length {
	static public int solution(String dirs) {
        int x = 0;
        int y = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < dirs.length(); i++) {
            char s = dirs.charAt(i);
            int nx = x;
            int ny = y;
            switch (s) {
                case 'U':
                    nx--;
                    break;
                case 'D':
                    nx++;
                    break;
                case 'L':
                    ny--;
                    break;
                case 'R':
                    ny++;
                    break;
            }
            String tmp1 = x + "," + y + "," + nx + "," + ny;
            String tmp2 = nx + "," + ny + "," + x + "," + y;
			if (nx < -5 || nx > 5 || ny < -5 || ny > 5) {
				nx = x;
				ny = y;
			} else if (!list.contains(tmp1) && !list.contains(tmp2)) {
				list.add(tmp1);
				list.add(tmp2);
            }
			x = nx;
			y = ny;
		}
        return list.size() / 2;
    }
	public static void main(String[] args) {
		String dirs = "ULURRDLLU";
		System.out.println(solution(dirs));

		String dirs2 = "LULLLLLLU";
		System.out.println(solution(dirs2));
	}
}
