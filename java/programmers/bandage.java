package programmers;

public class bandage {
	static public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;

        int time = 1;
        int bTime = 1;
        int end = attacks[attacks.length - 1][0];
        int aIdx = 0;
        while (time <= end) {
            if (time == attacks[aIdx][0]) {
                answer -= attacks[aIdx][1];
                if (answer <= 0)
                    return -1;
                bTime = 1;
                aIdx++;
            } else {
                answer = answer + bandage[1] > health ? health : answer + bandage[1];
                if (bTime == bandage[0]) {
                    answer = answer + bandage[2] > health ? health : answer + bandage[2];
                    bTime = 1;
                } else
                    bTime++;
            }
            time++;
        }
        return answer;
    }

	public static void main(String[] args) {
		int[] bandage = {5, 1, 5};
		int health = 30;
		int[][] attacks = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};
		System.out.println(solution(bandage, health, attacks));
	}
}
