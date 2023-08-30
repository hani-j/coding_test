// 코딩테스트 연습 - 코딩테스트 입문
// 삼각형의 완성조건 (2)

// 문제 설명
// 선분 세 개로 삼각형을 만들기 위해서는 다음과 같은 조건을 만족해야 합니다.

// 가장 긴 변의 길이는 다른 두 변의 길이의 합보다 작아야 합니다.
// 삼각형의 두 변의 길이가 담긴 배열 sides이 매개변수로 주어집니다. 나머지 한 변이 될 수 있는 정수의 개수를 return하도록 solution 함수를 완성해주세요.

// 제한사항
// sides의 원소는 자연수입니다.
// sides의 길이는 2입니다.
// 1 ≤ sides의 원소 ≤ 1,000

class Solution {
    public int solution(int[] sides) {
        int max = sides[0];
        int min = sides[1];
        if (sides[1] > sides[0]) {
            max = sides[1];
            min = sides[0];
        }
        return (min+max-1)-(max-min);
    }
}

// for (int i = (sides[0]>sides[1]?sides[0]-sides[1]:sides[1]-sides[0])+1; i < sides[0] + sides[1]; i++)  cnt++;