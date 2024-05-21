package programmers;

public class rectangle {
	static public int solution(int[][] sizes) {
        int mw = 0;
        int mh = 0;

        for (int[] size : sizes) {
            int w = Math.max(size[0], size[1]);
            int h = Math.min(size[0], size[1]);

            mw = Math.max(mw, w);
            mh = Math.max(mh, h);
        }

        return mw * mh;
    }

	public static void main(String[] args) {
		int[][] sizes1 = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
		int[][] sizes2 = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
		int[][] sizes3 = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};
		
		System.out.println(solution(sizes1));
		System.out.println(solution(sizes2));
		System.out.println(solution(sizes3));
	}
}
