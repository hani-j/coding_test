// 코딩테스트 연습 - 코딩테스트 입문
// 짝수는 싫어요

// 문제 설명
// 정수 n이 매개변수로 주어질 때, n 이하의 홀수가 오름차순으로 담긴 배열을 return하도록 solution 함수를 완성해주세요.

// 제한사항
// 1 ≤ n ≤ 100


class Solution {
    public int[] solution(int n) {

        int index = 0;
        int num = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) 
                num++;
        }
        int[] answer = new int[num];
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) 
                answer[index++] = i;
        }
        return answer;
    }
}

// return IntStream.rangeClosed(0, n).filter(value -> value % 2 == 1).toArray();