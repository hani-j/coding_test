package programmers;

public class skill {
	static public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int idx = 0;
        for (String sk : skill_trees) {
            boolean pos = true;
            for (int i = 0; i < sk.length(); i++) {
                for (int j = idx; j < skill.length(); j++) {
                    if (j != idx && sk.charAt(i) == skill.charAt(j))
                        pos = false;
					else if (sk.charAt(i) == skill.charAt(j)) {
                        idx++;
                        break;                        
                    }
                }
            }
            if (pos)
                answer++;
            idx = 0;
        }
        return answer;
    }

	public static void main(String[] args) {
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		System.out.println(solution(skill, skill_trees));
	}
}
