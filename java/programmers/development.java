package programmers;

import java.util.ArrayList;
import java.util.List;

public class development {
	static public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        List<Integer> count = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            int plus = (100 - progress) % speed != 0 ? 1 : 0;
            int day =  ((100 - progress) / speed) + plus;
            list.add(day);
        }        

        int idx = 0;
        int day = list.get(0);
        for (int i = 0; i < progresses.length; i++) {
            int iday = list.get(i);
            int c = 0;
            if (iday > day)
                day = iday;
            while (iday <= day) {
                c++;
                i++;
                if (i == progresses.length)
                    break;
                iday = list.get(i);
            }
            count.add(c);
            i--;
            idx++;
        }
        int[] answer = new int[count.size()];
        for (int i = 0; i < count.size(); i++) {
            answer[i] = count.get(i);
        }
        return answer;
    }

	public static void main(String[] args) {
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		int[] answer = solution(progresses, speeds);
		for (int n : answer)
			System.out.print(n + " ");
	}
}
