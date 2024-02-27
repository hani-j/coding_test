package thisis;

// implementation 10
public class lockKey {
	public static void main(String[] args) {
		int[][] key = {{0,0,0}, {1,0,0}, {0,1,1}};
		int[][] lock = {{1,1}, {1,1}};
		boolean answer = true;
        int[] count = new int[4];
        int num = 0;
        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock.length; j++) {
				int l = lock[i][j];
				num++;
				int a = i;
				int b = j;
				for (int k = 0; k < 4; k++) {
					if (a >= key.length && b >= key.length) {
						int tmp = b;
						b = lock.length - a;
						a = tmp;
						continue;
					}
					if (key[a][b] != l)
						count[k]++;
					int tmp = b;
					b = lock.length - 1 - a;
					a = tmp;
				}
            }
        }
        for (int i = 0; i < lock.length; i++) {
            if (count[i] == num)
                answer = true;
        }
		System.out.println(answer);
	}
}
