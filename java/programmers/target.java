package programmers;

public class target {
	static int[] nums;
    static int answer;
    static int tar;
    static public int solution(int[] numbers, int target) {
        answer = 0;
        nums = numbers;
        tar = target;
        cal(0, 0);
        return answer;
    }
    
    static public void cal(int d, int num) {
        if (d == nums.length) {
            if (num == tar)
                answer++;
            return ;
        }
        cal(d + 1, num + nums[d]);
        cal(d + 1, num - nums[d]);
    }

	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		System.out.println(solution(numbers, target));
	}
}
