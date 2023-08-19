// 코딩테스트 연습 - 코딩테스트 입문
// 자릿수 더하기

// 문제 설명
// 정수 n이 매개변수로 주어질 때 n의 각 자리 숫자의 합을 return하도록 solution 함수를 완성해주세요

// 제한사항
// 0 ≤ n ≤ 1,000,000

class Solution {
    public int solution(int n) {
        String str = Integer.toString(n);
        int answer = 0;
        for (int i = 0; i < str.length(); i++) {
            answer += str.charAt(i) -'0';
        }
        return answer;
    }
}