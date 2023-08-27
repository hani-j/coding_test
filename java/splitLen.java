// 코딩테스트 연습 - 코딩테스트 입문
// 잘라서 배열로 저장하기

// 문제 설명
// 문자열 my_str과 n이 매개변수로 주어질 때, my_str을 길이 n씩 잘라서 저장한 배열을 return하도록 solution 함수를 완성해주세요.

// 제한사항
// 1 ≤ my_str의 길이 ≤ 100
// 1 ≤ n ≤ my_str의 길이
// my_str은 알파벳 소문자, 대문자, 숫자로 이루어져 있습니다.

class Solution {
    public String[] solution(String my_str, int n) {
        int len;
        int strlen = my_str.length();
        if (strlen % n > 0)
            len = strlen / n + 1;
        else
            len = strlen / n;
        String[] answer = new String[len];
        for (int i = 0, start = 0; i < len; i++, start += n) {
            if (start + n > strlen)
                answer[i] = my_str.substring(start, strlen);
            else
                answer[i] = my_str.substring(start, start + n);
        }
        return answer;
    }
}