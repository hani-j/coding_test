package thisis;

public class muji {
	public static void main(String[] args) {
		int[] food_times = {1, 10, 10};
		int k = 6;

		int result = 0;
		k++;
        while (true) {
            int check = 0;
            for (int i = 0; i < food_times.length; i++) {
                if (food_times[i] > 0) {
                    check++;
                    k--;
                    food_times[i]--;
                }
                if (k == 0) {
                    result = i + 1;
                    break;
                }
            }
            if (result > 0) {
                break;
            }
            if (check == 0) {
                result = -1;
                break;
            }
            check = 0;
        }
        System.out.println(result);
	}
}
