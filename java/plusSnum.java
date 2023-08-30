// 코딩테스트 연습 - 코딩테스트 입문
// 숨어있는 숫자의 덧셈 (2)

// 문제 설명
// 문자열 my_string이 매개변수로 주어집니다. my_string은 소문자, 대문자, 자연수로만 구성되어있습니다. my_string안의 자연수들의 합을 return하도록 solution 함수를 완성해주세요.

// 제한사항
// 1 ≤ my_string의 길이 ≤ 1,000
// 1 ≤ my_string 안의 자연수 ≤ 1000
// 연속된 수는 하나의 숫자로 간주합니다.
// 000123과 같이 0이 선행하는 경우는 없습니다.
// 문자열에 자연수가 없는 경우 0을 return 해주세요.

class Solution {
    public int solution(String my_string) {
        int answer = 0;
        for (int i = 0; i < my_string.length(); i++) {
            if (i < my_string.length() && my_string.charAt(i) >= '0' && my_string.charAt(i) <= '9'){
                int j = i + 1;
                String num = "";
                num += my_string.charAt(i)+"";
                while (j < my_string.length() && my_string.charAt(j) >= '0' && my_string.charAt(j) <= '9') {
                    num += my_string.charAt(j++)+"";
                }
                answer += Integer.parseInt(num);
                i = j;
            }
        }
        return answer;
    }
}

// String[] str = my_string.replaceAll("[a-zA-Z]", " ").split(" ");
