// 코딩테스트 연습 - 코딩테스트 입문
// 최댓값 만들기 (2)

// 문제 설명
// 정수 배열 numbers가 매개변수로 주어집니다. numbers의 원소 중 두 개를 곱해 만들 수 있는 최댓값을 return하도록 solution 함수를 완성해주세요.

// 제한사항
// -10,000 ≤ numbers의 원소 ≤ 10,000
// 2 ≤ numbers 의 길이 ≤ 100

import java.util.Arrays;
class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int Max = numbers[numbers.length - 1] * numbers[numbers.length - 2];
        int Min = numbers[0] * numbers[1];
        return Max > Min ? Max : Min;
    }
}